package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.DatabaseTableModel;
import edu.neu.csye6200.model.Parent;
import edu.neu.csye6200.model.ParentDao;
import edu.neu.csye6200.view.ParentMangerPanel;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

public class ParentManagePanelController // CONTROLLER
{
    public ParentManagePanelController() {
        panel = new ParentMangerPanel();
        panel.table.setModel(tableModel);
        tableModel.refresh();

        panel.refreshButton.addActionListener(e -> {
            tableModel.refresh();
        });
        panel.addButton.addActionListener(e -> {
            tableModel.addEmpty();
        });
    }

    private final DatabaseTableModel<Parent, ParentDao> tableModel = new DatabaseTableModel<>(Parent.class, ParentDao.class); // MODEL
    private TableRowSorter<DatabaseTableModel<Parent, ParentDao>> tableRowSorter = new TableRowSorter<>(tableModel);
    private final JPopupMenu tableRightClickMenu = new JPopupMenu();

    public ParentMangerPanel getPanel() { return panel; }
    private ParentMangerPanel panel; // VIEW
}
