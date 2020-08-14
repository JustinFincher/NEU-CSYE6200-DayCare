package edu.neu.csye6200.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskAction extends AbstractAction {

    public TaskAction(String name) {
        super(name);
    }

    public TaskAction(String name, Icon icon) {
        super(name, icon);
    }

    public TaskAction(String name, Icon icon, ActionListener listener) {
        super(name, icon);
        this.listener = listener;
    }

    public void setListener(ActionListener listener) {
        this.listener = listener;
    }
    private ActionListener listener;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (listener != null)
        {
            listener.actionPerformed(e);
        }
    }
}
