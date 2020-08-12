package edu.neu.csye6200.manager;

import com.formdev.flatlaf.FlatIntelliJLaf;
import edu.neu.csye6200.view.MainForm;

import javax.swing.*;

public enum GUIManager {
	INSTANCE;
	public static GUIManager getInstance()
	{
		return INSTANCE;
	}

	GUIManager()
	{
		FlatIntelliJLaf.install();
	}

	public void show()
	{
		JFrame frame = new JFrame("MainForm");
		frame.setContentPane(new MainForm().panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
