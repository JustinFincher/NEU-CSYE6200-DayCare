package edu.neu.csye6200.controller;

import edu.neu.csye6200.helper.Log;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.model.*;
import edu.neu.csye6200.view.StudentManagePanel;
import org.jdesktop.swingx.search.PatternMatcher;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class StudentManagePanelController
{
    public StudentManagePanel getPanel() { return panel; }
    private StudentManagePanel panel;

    private final DatabaseTableModel<Student, StudentDao> tableModel = new DatabaseTableModel<>(Student.class, StudentDao.class);
    private TableRowSorter<DatabaseTableModel<Student, StudentDao>> tableRowSorter = new TableRowSorter<>(tableModel);
    private final JPopupMenu tableRightClickMenu = new JPopupMenu();

    public StudentManagePanelController() {
        panel = new StudentManagePanel();
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

        panel.exportTableButton.addActionListener(event -> {
            String s = DatabaseManager.getDB().onDemand(StudentDao.class).exportCSV(Student.class);
            String fileName = "student.csv";
            String home = System.getProperty("user.home");
            Path path = Paths.get(home,"Downloads", fileName);
            File file = path.toFile();
            try {
                if (file.exists()) {
                    boolean delete = file.delete();
                }
                FileWriter writer = new FileWriter(path.toString());
                writer.write(s);
                writer.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failed due to " + e.getMessage());
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Saved to " + path);
        });

        panel.importTableButton.addActionListener(event -> {
            JFileChooser jfc=new JFileChooser();
            jfc.setFileFilter(new FileNameExtensionFilter("CSV Files","csv"));
            jfc.setFileSelectionMode(JFileChooser.FILES_ONLY );
            jfc.showDialog(new JLabel(), "Select");
            File file=jfc.getSelectedFile();
            if(file.isFile())
            {
                try {
                    String s = new String(Files.readAllBytes(file.toPath()));
                    DatabaseManager.getDB().onDemand(StudentDao.class).importCSV(s, Student.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed due to " + e.getMessage());
                }
            }
            JOptionPane.showMessageDialog(null, "Success");
            tableModel.refresh();
        });
    }
}
