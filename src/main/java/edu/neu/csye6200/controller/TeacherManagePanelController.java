package edu.neu.csye6200.controller;

import edu.neu.csye6200.view.TeacherManagePanel;

/**
 * Controller for {@link TeacherManagePanel TeacherManagePanel}
 * @author Haotian Zheng
 */
public class TeacherManagePanelController {
    public TeacherManagePanel getPanel() { return panel; }
    private TeacherManagePanel panel;

    TeacherManagePanelController()
    {
        panel = new TeacherManagePanel();
    }
}
