/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xiangjingru
 */

package edu.neu.csye6200.controller;

import edu.neu.csye6200.manager.AdminManager;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.manager.GUIManager;
import edu.neu.csye6200.model.Parent;
import edu.neu.csye6200.model.ParentDao;
import edu.neu.csye6200.view.ParentInsertDialog;
import edu.neu.csye6200.view.ParentManagePanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.util.Optional;

public class ParentInsertController {
    public ParentInsertDialog getDialog() { return insertDialog; }
    public ParentInsertDialog insertDialog;

    
    
    public ParentInsertController(JFrame frame)
    {
        insertDialog = new ParentInsertDialog(frame, true);
        insertDialog.pack();
        
    }
    
    

   
}
