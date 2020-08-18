package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.DBObject;
import edu.neu.csye6200.view.DBObjectEditDialog;

import java.awt.*;

public class DBObjectEditDialogController<T extends DBObject>
{
    private T object;
    private DBObjectEditDialog dialog;
    public DBObjectEditDialogController(Frame parent, T object)
    {
        this.object = object;
        dialog = new DBObjectEditDialog(parent, false);
    }
}
