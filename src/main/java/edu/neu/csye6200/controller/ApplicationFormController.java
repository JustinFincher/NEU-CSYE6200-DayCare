package edu.neu.csye6200.controller;

import edu.neu.csye6200.helper.SQLUtils;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.StudentDao;
import edu.neu.csye6200.view.ApplicationForm;
import edu.neu.csye6200.view.DashboardPanel;
import edu.neu.csye6200.view.StudentManagePanel;

public class ApplicationFormController
{
    private ApplicationForm form;
    public ApplicationFormController()
    {
        form = new ApplicationForm();
//        List<Teacher> teachers = DatabaseManager.getDB().withExtension(TeacherDao.class, TeacherDao::listTeachers);
        DatabaseManager.getDB()
                .onDemand(StudentDao.class)
                .createTable(SQLUtils.getTableName(Student.class), SQLUtils.getProperties(Student.class));
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
    }
}
