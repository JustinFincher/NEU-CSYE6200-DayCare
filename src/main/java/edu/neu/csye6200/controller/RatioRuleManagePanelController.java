package edu.neu.csye6200.controller;

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
            String s = DatabaseManager.getDB().onDemand(RatioRuleDao.class).exportCSV(RatioRule.class);
            String fileName = "ratiorules.csv";
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
                    DatabaseManager.getDB().onDemand(RatioRuleDao.class).importCSV(s, RatioRule.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed due to " + e.getMessage());
                }
            }
            JOptionPane.showMessageDialog(null, "Success");
            model.refresh();
        });
    }
}
