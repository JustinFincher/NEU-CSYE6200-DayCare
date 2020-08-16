package edu.neu.csye6200.controller;

import edu.neu.csye6200.helper.SQLUtils;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.StudentDao;
import edu.neu.csye6200.view.ApplicationForm;
import edu.neu.csye6200.view.DashboardPanel;
import edu.neu.csye6200.view.StudentManagePanel;

import java.awt.*;

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
            form.splitViewContentPanel.add(new StudentManagePanel());
            form.splitViewContentPanel.revalidate();
            form.splitViewContentPanel.repaint();
        });
        form.dashboardAction.setListener(e -> {
            form.splitViewContentPanel.removeAll();
            form.splitViewContentPanel.add(new DashboardPanel());
            form.splitViewContentPanel.revalidate();
            form.splitViewContentPanel.repaint();
        });

        DatabaseManager.getDB()
                .onDemand(StudentDao.class)
                .createTable(SQLUtils.getTableName(Student.class), SQLUtils.getProperties(Student.class));
    }
}
