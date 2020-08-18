package edu.neu.csye6200.controller;

import edu.neu.csye6200.manager.AdminManager;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.view.ApplicationForm;
import edu.neu.csye6200.view.DashboardPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ApplicationFormController
{
    public ApplicationForm getForm() { return form; }
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
        form.manageStudentAction.setListener(e -> {
            form.switchTo(new StudentManagePanelController().getPanel());
        });
        form.manageParentAction.setListener(e -> {
            form.switchTo(new ParentManagePanelController().getPanel());
        });
        form.dashboardAction.setListener(e -> {
            form.switchTo(new DashboardPanel());
        });
        form.manageTeacherAction.setListener(e -> {
            form.switchTo(new TeacherManagePanelController().getPanel());
        });
        form.manageRatioRuleAction.setListener(e -> {
            form.switchTo(new RatioRuleManagePanelController().getPanel());
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
        form.documentationMenuItem.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://justinfincher.github.io/NEU-CSYE6200-DayCare/"));
            } catch (IOException | URISyntaxException ioException) {
                ioException.printStackTrace();
            }
        });
        form.loginMenuItem.addActionListener(e -> {
            show();
        });
        form.logoutMenuItem.addActionListener(e -> {
            AdminManager.getInstance().logOut();
            show();
        });
    }

    public void show()
    {
        if (!AdminManager.getInstance().isLoggedIn())
        {
            form.setVisible(false);
            new LoginDialogController(this.form).show();
            refresh();
        }else {
            form.setVisible(true);
        }
    }

    public void refresh()
    {
        form.logoutMenuItem.setEnabled(AdminManager.getInstance().isLoggedIn());
        form.loginMenuItem.setEnabled(!AdminManager.getInstance().isLoggedIn());
        form.loginMenu.setText(AdminManager.getInstance().isLoggedIn() ?
                "Welcome, " + AdminManager.getInstance().getLoggedInTeacher().getRealName():
                "Click to login");
    }
}
