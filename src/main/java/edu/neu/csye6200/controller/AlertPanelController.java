package edu.neu.csye6200.controller;

import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.StudentDao;
import edu.neu.csye6200.view.AlertPanel;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlertPanelController {

    public AlertPanelController() {
        this.panel = new AlertPanel();
        this.panel.refreshTableButton.addActionListener(e -> {
            refresh();
        });
        refresh();
    }

    private void refresh() {
        // mock data
        panel.scrollContentView.removeAll();
        DatabaseManager.getDB().onDemand(StudentDao.class).list(Student.class)
                .stream().limit(10).forEach(s ->
        {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setText(s.getRealName() + " need vaccine on " + s.getWalkInTime().plusYears(1));
            checkBox.addItemListener(e -> {
                if(e.getStateChange() == ItemEvent.SELECTED) {
//                    int i = Arrays.asList(panel.scrollContentView.getComponents()).indexOf(e.getSource());
//                    list.remove(i);
                    panel.scrollContentView.remove(checkBox);
                    panel.scrollContentView.invalidate();
                    panel.scrollContentView.repaint();
//                    refresh();
                }
            });
            panel.scrollContentView.add(checkBox);
        });
        panel.scrollContentView.invalidate();
        panel.scrollContentView.repaint();
    }

    public AlertPanel getPanel() { return panel; }
    private AlertPanel panel;


}
