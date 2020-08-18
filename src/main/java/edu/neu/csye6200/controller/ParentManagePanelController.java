package edu.neu.csye6200.controller;

import edu.neu.csye6200.helper.Log;
import edu.neu.csye6200.model.DatabaseTableModel;
import edu.neu.csye6200.model.Parent;
import edu.neu.csye6200.model.ParentDao;
import edu.neu.csye6200.view.ParentManagePanel;
import edu.neu.csye6200.controller.ParentInsertController;
import edu.neu.csye6200.view.ParentInsertDialog;
import edu.neu.csye6200.view.StudentManagePanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.search.PatternMatcher;

public class ParentManagePanelController // CONTROLLER
{
  //  public ParentManagePanelController() {
      //  panel = new ParentMangerPanel();
   //     panel.table.setModel(tableModel);
    //    tableModel.refresh();

    //    panel.refreshButton.addActionListener(e -> {
    //        tableModel.refresh();
    //    });
    //    panel.addButton.addActionListener(e -> {
     //       tableModel.addEmpty();
    //    });
   // }

    private final DatabaseTableModel<Parent, ParentDao> tableModel = new DatabaseTableModel<>(Parent.class, ParentDao.class); // MODEL
    private TableRowSorter<DatabaseTableModel<Parent, ParentDao>> tableRowSorter = new TableRowSorter<>(tableModel);
    private final JPopupMenu tableRightClickMenu = new JPopupMenu();

    public ParentManagePanel getPanel() {
        return panel;
    }
    private ParentManagePanel panel; // VIEW
    
        
    public ParentManagePanelController() {
        panel = new ParentManagePanel();
       // panel.pack();
        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(e -> {
            tableModel.delete(panel.table, panel.table.getSelectedRows());
        });
        panel.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                maybeShowPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                maybeShowPopup(e);
            }

            private void maybeShowPopup(MouseEvent e) {
                if (e.isPopupTrigger() && panel.table == e.getSource()) {
                    int row = panel.table.rowAtPoint(e.getPoint());
                    int column = panel.table.columnAtPoint(e.getPoint());
                    tableRightClickMenu.removeAll();
                    if (row >= 0 && row < panel.table.getRowCount()) {
                        tableRightClickMenu.add(deleteItem);
                        if (!panel.table.isRowSelected(row)) {
                            panel.table.changeSelection(row, column, false, false);
                        }
                    } else {
                        panel.table.clearSelection();
                    }
                    tableRightClickMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        panel.table.setModel(tableModel);
        tableModel.refresh();

        panel.exportTableButton.addActionListener(e -> {

        });
        panel.importTableButton.addActionListener(e -> {

        });
        panel.addParentButton.addActionListener(e -> {
            tableModel.addEmpty();
        });
        panel.refreshTableButton.addActionListener(e -> {
            tableModel.refresh();
        });
        panel.insertTableButton.addActionListener(e ->{
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(getPanel());
            new ParentInsertController(topFrame).getDialog().setVisible(true);  
        });
        
        
        /*myButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       ThisGuiClass.this.setVisible(false);
       newGUI.setVisible(true);
    }
});*/
        
        
        panel.searchPanel.addPatternMatcher(new PatternMatcher() {
            @Override
            public Pattern getPattern() {
                return null;
            }

            @Override
            public void setPattern(Pattern pattern) {
                if (pattern != null)
                {
                    Log.i(pattern.pattern());
                    tableRowSorter.setRowFilter(RowFilter.regexFilter(pattern.pattern()));
                }else {
                    tableRowSorter.setRowFilter(null);
                }
            }
        });
        tableRowSorter = new TableRowSorter<>(tableModel);
        panel.table.setRowSorter(tableRowSorter);
//        panel.table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
//
//        });
    }
        
    //public void show()
	//{
	//	controller.show();
	//}
    
}
