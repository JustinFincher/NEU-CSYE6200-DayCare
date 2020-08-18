/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.controller;

import edu.neu.csye6200.helper.Log;
import edu.neu.csye6200.model.DatabaseTableModel;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.TeacherDao;
import edu.neu.csye6200.view.TeacherManagePanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.search.PatternMatcher;

/**
 *
 * @author qc
 */
public class TeacherManagePanelController {
    public TeacherManagePanel getPanel() { return panel; }
    private TeacherManagePanel panel;

    private final DatabaseTableModel<Teacher, TeacherDao> tableModel = new DatabaseTableModel<>(Teacher.class, TeacherDao.class);
    private TableRowSorter<DatabaseTableModel<Teacher, TeacherDao>> tableRowSorter = new TableRowSorter<>(tableModel);
    private final JPopupMenu tableRightClickMenu = new JPopupMenu();

    public TeacherManagePanelController() {
        panel = new TeacherManagePanel();
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
            File file=new File("results.xls");
            FileWriter out = null;
            try {
                out = new FileWriter(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            for(int i=0; i < tableModel.getColumnCount(); i++) {
                try {
                    out.write(tableModel.getColumnName(i) + "\t");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                out.write("\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            for(int i=0; i<tableModel.getRowCount(); i++) {
                for(int j=0; j <tableModel.getColumnCount(); j++) {
                    try {
                        out.write(tableModel.getValueAt(i,j).toString()+"\t");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                try {
                    out.write("\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("write out to: " + file);


        });

        panel.importTableButton.addActionListener(e -> {

            JFileChooser jfc=new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
            jfc.showDialog(new JLabel(), "选择");
            File file=jfc.getSelectedFile();
            if(file.isDirectory()){
                System.out.println("文件夹:"+file.getAbsolutePath());
            }else if(file.isFile()){
                System.out.println("文件:"+file.getAbsolutePath());
            }
            System.out.println(jfc.getSelectedFile().getName());

            
        });
        panel.addStudentButton.addActionListener(e -> {
            tableModel.addEmpty();
        });
        panel.refreshTableButton.addActionListener(e -> {
            tableModel.refresh();
        });

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
        panel.table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){

        });
    }
}
