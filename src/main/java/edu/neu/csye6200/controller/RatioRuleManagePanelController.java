package edu.neu.csye6200.controller;

import edu.neu.csye6200.helper.FileUtils;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.model.*;
import edu.neu.csye6200.view.RatioRuleManagePanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RatioRuleManagePanelController {
    // VIEW
    public RatioRuleManagePanel getPanel() { return panel; }
    private RatioRuleManagePanel panel;
    private final JPopupMenu tableRightClickMenu = new JPopupMenu();

    // MODEL
    private DatabaseTableModel<RatioRule, RatioRuleDao> model = new DatabaseTableModel<>(RatioRule.class, RatioRuleDao.class);

    RatioRuleManagePanelController()
    {
        panel = new RatioRuleManagePanel();
        panel.table.setModel(model);
        model.refresh();

        panel.refreshTableButton.addActionListener(e -> {
            model.refresh();
        });
        panel.addRuleButton.addActionListener(e -> {
            model.addEmpty();
        });

        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(e -> {
            model.delete(panel.table, panel.table.getSelectedRows());
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

        panel.exportTableButton.addActionListener(event -> {
            FileUtils.exportCSV(RatioRule.class, RatioRuleDao.class);
        });

        panel.importTableButton.addActionListener(event -> {
            FileUtils.importCSV(RatioRule.class, RatioRuleDao.class);
            model.refresh();
        });
    }
}
