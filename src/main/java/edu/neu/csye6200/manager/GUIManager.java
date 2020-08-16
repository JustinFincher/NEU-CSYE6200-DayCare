package edu.neu.csye6200.manager;

import com.formdev.flatlaf.FlatIntelliJLaf;
import edu.neu.csye6200.controller.ApplicationFormController;
import edu.neu.csye6200.helper.Log;
import edu.neu.csye6200.view.ApplicationForm;
import javax.swing.*;

public enum GUIManager {
	INSTANCE;
	public static GUIManager getInstance()
	{
		return INSTANCE;
	}

	GUIManager()
	{
		if (System.getProperty("os.name", "").startsWith("Mac OS")) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("apple.awt.textantialiasing", "true");
		}

		FlatIntelliJLaf.install();
	}

	public void start()
	{
		new ApplicationFormController();
	}
}
