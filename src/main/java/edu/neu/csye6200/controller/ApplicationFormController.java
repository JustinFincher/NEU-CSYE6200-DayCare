package edu.neu.csye6200.controller;

import edu.neu.csye6200.helper.Log;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.view.ApplicationForm;
import edu.neu.csye6200.view.DashboardPanel;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ApplicationFormController
{
    private ApplicationForm form;
    public ApplicationFormController()
    {
        form = new ApplicationForm();
        form.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        form.setSize((int) (width*0.75), (int) (height*0.75));
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        form.manageStudentAction.setListener(e -> {
            form.splitViewContentPanel.removeAll();
            form.splitViewContentPanel.add(new StudentManagePanelController().getPanel());
            form.splitViewContentPanel.revalidate();
            form.splitViewContentPanel.repaint();
        });
        form.dashboardAction.setListener(e -> {
            form.splitViewContentPanel.removeAll();
            form.splitViewContentPanel.add(new DashboardPanel());
            form.splitViewContentPanel.revalidate();
            form.splitViewContentPanel.repaint();
        });
        form.manageParentAction.setListener(e -> {
            Log.i("About to switch to parent panel");
            form.splitViewContentPanel.removeAll();
            form.splitViewContentPanel.add(new ParentManagePanelController().getPanel());
            form.splitViewContentPanel.revalidate();
            form.splitViewContentPanel.repaint();
        });

        form.showDatabaseMenuItem.addActionListener(e -> {
            File dbFile = DatabaseManager.getInstance().getFile();
            try {
                if (dbFile.exists())
                    Desktop.getDesktop().open(dbFile);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        form.destroyDatabaseMenuItem.addActionListener(e -> {
            File dbFile = DatabaseManager.getInstance().getFile();
            if (dbFile.exists())
                dbFile.deleteOnExit();
            System.exit(0);
        });
        form.loadMockDataMenuItem.addActionListener(e -> {

        });
    }
}
