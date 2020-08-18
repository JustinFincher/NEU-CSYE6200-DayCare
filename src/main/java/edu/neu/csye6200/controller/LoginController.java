package edu.neu.csye6200.controller;

import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.model.*;
import edu.neu.csye6200.view.LoginPanel;

import java.awt.*;

/**
 * @deprecated
 */
public class LoginController
{
    public LoginPanel getPanel() { return panel; }
    private LoginPanel panel;

    public LoginController() {

        panel.Login.addActionListener(e->{
            if(!DatabaseManager.getDB().onDemand(User.class).getUserName().equalsIgnoreCase(panel.Id.getText())){
                panel.Warnning.setText("*Incorrect Id or Password");
                panel.Warnning.setForeground(Color.RED);
                panel.Wrong_id.setText("*");
                panel.Wrong_id.setForeground(Color.RED);
            }
            else if(!DatabaseManager.getDB().onDemand(User.class).getHashedPassword().equalsIgnoreCase(panel.Password.getText())){
                panel.Warnning.setText("*Incorrect Id or Password");
                panel.Warnning.setForeground(Color.RED);
                panel.Wrong_password.setText("*");
                panel.Wrong_password.setForeground(Color.RED);
            }
            else if(!DatabaseManager.getDB().onDemand(User.class).getUserName().equalsIgnoreCase(panel.Id.getText())||!DatabaseManager.getDB().onDemand(User.class).getHashedPassword().equalsIgnoreCase(panel.Password.getText())){
                panel.Warnning.setText("*Incorrect Id or Password");
                panel.Warnning.setForeground(Color.RED);
                panel.Wrong_password.setText("*");
                panel.Wrong_password.setForeground(Color.RED);
                panel.Wrong_id.setText("*");
                panel.Wrong_id.setForeground(Color.RED);
            }
            else{
                panel.setVisible(false);
            }
        });


    }
}
