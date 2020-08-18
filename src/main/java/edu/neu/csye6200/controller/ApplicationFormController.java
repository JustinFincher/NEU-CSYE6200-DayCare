package edu.neu.csye6200.controller;

import com.google.common.io.Resources;
import edu.neu.csye6200.helper.SQLUtils;
import edu.neu.csye6200.manager.AdminManager;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.model.*;
import edu.neu.csye6200.view.ApplicationForm;
import edu.neu.csye6200.view.DashboardPanel;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

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
            form.switchTo(new DashboardController().getPanel());
        });
        form.manageTeacherAction.setListener(e -> {
            form.switchTo(new TeacherManagePanelController().getPanel());
        });
        form.manageRatioRuleAction.setListener(e -> {
            form.switchTo(new RatioRuleManagePanelController().getPanel());
        });
        form.manageClassroomAction.setListener(e -> {
            form.switchTo(new ClassroomManagePanelController().getPanel());
        });
        form.alertAction.setListener(e -> {
            form.switchTo(new AlertPanelController().getPanel());
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
        form.loadMockDataMenuItem.addActionListener(event -> {
            List<AbstractMap.SimpleEntry<Class<? extends DBObject>, Class<? extends CrudDao<DBObject>>>> list = new ArrayList<>();
            list.add(new AbstractMap.SimpleEntry(Student.class, StudentDao.class));
            list.add(new AbstractMap.SimpleEntry(Parent.class, ParentDao.class));
            list.add(new AbstractMap.SimpleEntry(Teacher.class, TeacherDao.class));
            list.add(new AbstractMap.SimpleEntry(Classroom.class, ClassroomDao.class));
            list.add(new AbstractMap.SimpleEntry(RatioRule.class, RatioRuleDao.class));
            list.forEach(pair -> {
                String text = null;
                try {
                    String s = SQLUtils.getKeyInString(pair.getKey().getSimpleName());
                    URL url = Resources.getResource(s + ".csv");
                    text = Resources.toString(url, StandardCharsets.UTF_8);
                    if (text == null) return;
                    DatabaseManager.getDB().onDemand(pair.getValue()).reset((Class<DBObject>) pair.getKey());
                    DatabaseManager.getDB().onDemand(pair.getValue()).importCSV(text, (Class<DBObject>) pair.getKey());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
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
