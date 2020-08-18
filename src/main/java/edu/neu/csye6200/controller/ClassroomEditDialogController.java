package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.ClassroomGroupsTreeModel;
import edu.neu.csye6200.view.ClassroomEditDialog;

import javax.swing.*;

public class ClassroomEditDialogController {

    public ClassroomEditDialogController(JFrame frame, Classroom classroom) {
        dialog = new ClassroomEditDialog(frame, false);
        this.classroom = classroom;

        dialog.titleLabel.setText(classroom.getRoomNumber());
        treeModel = new ClassroomGroupsTreeModel(classroom.getId());
        dialog.tree.setModel(treeModel);
    }

    public ClassroomEditDialog getDialog() { return dialog; }
    private ClassroomEditDialog dialog; // VIIEW

    private Classroom classroom; // MODEL
    private ClassroomGroupsTreeModel treeModel;

    public void show()
    {
        dialog.setVisible(true);
    }
}
