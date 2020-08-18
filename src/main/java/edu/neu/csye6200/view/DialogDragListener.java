package edu.neu.csye6200.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogDragListener extends MouseAdapter {

    private final JDialog dialog;
    private Point mouseDownCompCoords = null;

    public DialogDragListener(JDialog dialog) {
        this.dialog = dialog;
    }

    public void mouseReleased(MouseEvent e) {
        mouseDownCompCoords = null;
    }

    public void mousePressed(MouseEvent e) {
        mouseDownCompCoords = e.getPoint();
    }

    public void mouseDragged(MouseEvent e) {
        Point currCoords = e.getLocationOnScreen();
        dialog.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }
}