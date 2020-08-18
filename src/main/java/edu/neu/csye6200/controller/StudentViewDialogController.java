/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.view.StudentViewDialog;

import javax.swing.*;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Haotian Zheng
 */
public class StudentViewDialogController {

    public StudentViewDialogController(JFrame frame, Student student) {
        dialog = new StudentViewDialog(frame, false);
        this.student = student;
        dialog.titleLabel.setText(student.getRealName());
        dialog.cancelButton.addActionListener(e -> dialog.dispose());
        dialog.confirmButton.addActionListener(e -> {
            dialog.dispose();
        });
        dialog.realNameTextField.setText(student.getRealName());
        dialog.birthDayPicker.setDate(Date.from( student.getBirthDay().atZone( ZoneId.systemDefault()).toInstant()));
        dialog.walkInDatePicker.setDate(Date.from( student.getWalkInTime().atZone( ZoneId.systemDefault()).toInstant()));
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
