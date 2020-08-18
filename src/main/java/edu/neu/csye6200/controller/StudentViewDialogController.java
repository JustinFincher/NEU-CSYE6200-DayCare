/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.view.StudentViewDialog;

import javax.swing.*;

/**
 *
 * @author Haotian Zheng
 */
public class StudentViewDialogController {

    public StudentViewDialogController(JFrame frame, Student student) {
        dialog = new StudentViewDialog(frame, false);
        this.student = student;

        dialog.closeButton.addActionListener(e -> dialog.dispose());
    }

    public StudentViewDialog getDialog() { return dialog; }
    private StudentViewDialog dialog; // VIIEW

    private Student student; // MODEL

    public void show()
    {
        dialog.dispose();
        dialog.setUndecorated(true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

}
