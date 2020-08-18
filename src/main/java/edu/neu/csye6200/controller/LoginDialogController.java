package edu.neu.csye6200.controller;

import edu.neu.csye6200.manager.AdminManager;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.manager.GUIManager;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.TeacherDao;
import edu.neu.csye6200.view.LoginDialog;

import javax.swing.*;
import java.util.Optional;

public class LoginDialogController {
    public LoginDialog getDialog() { return dialog; }
    private LoginDialog dialog;

    public LoginDialogController(JFrame frame)
    {
        dialog = new LoginDialog(frame, true);
        dialog.loginButton.addActionListener(e -> {
            login();
        });
        dialog.passwordTextField.addActionListener(e -> {
            login();
        });
    }

    public void show()
    {
        dialog.dispose();
        dialog.setUndecorated(true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void login()
    {
        String userName = dialog.userNameTextField.getText();
        String password = new String(dialog.passwordTextField.getPassword());
        if (dialog.isPasswordPresent() && dialog.isUserNamePresent())
        {
            Optional<Teacher> teacher = DatabaseManager.getDB().onDemand(TeacherDao.class).findByUserName(userName);
            if (teacher.isPresent() && teacher.get().isPasswordRight(password))
            {
                AdminManager.getInstance().setLoggedInTeacher(teacher.get());
                dialog.dispose();
                GUIManager.getInstance().show();
            }
        }
    }
}
