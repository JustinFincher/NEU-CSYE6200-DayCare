package edu.neu.csye6200.manager;

import com.formdev.flatlaf.FlatIntelliJLaf;
import edu.neu.csye6200.controller.ApplicationFormController;
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
		FlatIntelliJLaf.install();
	}

	public void start()
	{
		new ApplicationFormController();
	}
}
