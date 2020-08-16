package edu.neu.csye6200.view;

import edu.neu.csye6200.helper.BeanUtils;
import edu.neu.csye6200.helper.Log;
import edu.neu.csye6200.helper.SQLUtils;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.model.CrudDao;
import edu.neu.csye6200.model.DBObject;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Vector;

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

    public void refresh()
    {
        columns = BeanUtils.getBeanProperties(modelClass);
        objectList = DatabaseManager.getDB().onDemand(daoClass).list(SQLUtils.getTableName(modelClass));
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
        return false;
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

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
