package edu.neu.csye6200.model;

import edu.neu.csye6200.helper.BeanUtils;
import edu.neu.csye6200.helper.SQLUtils;
import edu.neu.csye6200.manager.DatabaseManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/**
 * A generic table model to use with {@link javax.swing.JTable JTable} or {@link org.jdesktop.swingx.JXTable JXTable} <br>
 *
 * How to use:<br>
 * <pre>
 * {@literal
 *     JTable table;
 *     DatabaseTableModel<Student, StudentDao> tableModel = new DatabaseTableModel<>(Student.class, StudentDao.class);
 *     table.setModel(tableModel);
 *     tableModel.refresh();
 *     tableModel.addEmpty();
 *     tableModel.delete(table, table.getSelectedRows());
 * }
 * </pre>
 *
 * @param <MODEL> Model Class which extends {@link DBObject DBObject}, e.g. {@link Student Student}
 * @param <DAO> Dao Class which extends {@link CrudDao CrudDao}, e.g. {@link StudentDao StudentDao}
 * @author Haotian Zheng
 * @see edu.neu.csye6200.controller.StudentManagePanelController
 */
public class DatabaseTableModel<MODEL extends DBObject, DAO extends CrudDao<MODEL>> extends DefaultTableModel
{
    private final Class<MODEL> modelClass;
    private final Class<DAO> daoClass;
    private List<MODEL> objectList = new Vector<>();
    private List<PropertyDescriptor> columns = new Vector<>();

    public DatabaseTableModel(Class<MODEL> modelClass, Class<DAO> daoClass) {
        super();
        this.modelClass = modelClass;
        this.daoClass = daoClass;
    }

    /**
     * Call this to refresh data from SQLite and then fire update triggers of the table you plugged in
     */
    public void refresh()
    {
        columns = BeanUtils.getBeanProperties(modelClass);
        objectList = DatabaseManager.getDB().onDemand(daoClass).list(modelClass);
        fireTableStructureChanged();
    }

    public void addEmpty()
    {
        try {
            MODEL model = modelClass.newInstance();
            DatabaseManager.getDB().onDemand(daoClass).insert(model, modelClass);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        refresh();
    }

    public void delete(JTable table, int... rows)
    {
        Arrays.stream(rows).map(table::convertRowIndexToModel).mapToObj(i -> objectList.get(i)).filter(Objects::nonNull).map(DBObject::getId).forEach(integer -> {
            DatabaseManager.getDB().onDemand(daoClass).deleteById(SQLUtils.getTableName(modelClass), integer);
        });
        refresh();
    }

    public MODEL getRowAt(JTable table, int row)
    {
        return objectList.get(table.convertRowIndexToModel(row));
    }

    @Override
    public int getRowCount() {
        return objectList == null ? 0 : objectList.size();
    }

    @Override
    public int getColumnCount() {
        return columns == null ? 0 : columns.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns == null ? "" : columns.get(columnIndex).getName();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columns == null ? String.class : columns.get(columnIndex).getPropertyType();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columns != null && !columns.get(columnIndex).getName().equals("id"); // cannot change id easily
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columns != null)
        {
            try {
                return columns.get(columnIndex).getReadMethod().invoke(objectList.get(rowIndex));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        MODEL model = objectList.get(rowIndex);
        PropertyDescriptor propertyDescriptor = columns.get(columnIndex);
        try {
            propertyDescriptor.getWriteMethod().invoke(model, aValue);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        DatabaseManager.getDB().onDemand(daoClass).update(model, modelClass);
        refresh();
    }
}
