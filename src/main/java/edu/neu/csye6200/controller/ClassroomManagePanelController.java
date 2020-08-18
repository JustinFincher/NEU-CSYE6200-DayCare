package edu.neu.csye6200.controller;

import edu.neu.csye6200.helper.FileUtils;
import edu.neu.csye6200.helper.Log;
import edu.neu.csye6200.model.*;
import edu.neu.csye6200.view.ClassroomManagePanel;
import org.jdesktop.swingx.search.PatternMatcher;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

public class ClassroomManagePanelController {

    private final DatabaseTableModel<Classroom, ClassroomDao> tableModel = new DatabaseTableModel<>(Classroom.class, ClassroomDao.class); // MODEL
    private TableRowSorter<DatabaseTableModel<Classroom, ClassroomDao>> tableRowSorter = new TableRowSorter<>(tableModel);
    private final JPopupMenu tableRightClickMenu = new JPopupMenu();

    public ClassroomManagePanel getPanel() {
        return panel;
    }
    private ClassroomManagePanel panel; // VIEW

    public ClassroomManagePanelController() {
        panel = new ClassroomManagePanel();
        JMenuItem deleteItem = new JMenuItem("Delete");
        JMenuItem editItem = new JMenuItem("Edit (WIP)");
        editItem.addActionListener(e -> {
            int[] rows = panel.table.getSelectedRows();
            if (rows.length == 1)
            {
                Classroom classroom = tableModel.getRowAt(panel.table, rows[0]);
                new ClassroomEditDialogController((JFrame) SwingUtilities.getRoot(panel), classroom).show();
            }
        });
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
                        tableRightClickMenu.add(editItem);
                        tableRightClickMenu.add(new JSeparator());
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
        panel.addRuleButton.addActionListener(e -> {
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
            FileUtils.exportCSV(Classroom.class, ClassroomDao.class);
        });

        panel.importTableButton.addActionListener(event -> {
            FileUtils.importCSV(Classroom.class, ClassroomDao.class);
            tableModel.refresh();
        });
    }

}
