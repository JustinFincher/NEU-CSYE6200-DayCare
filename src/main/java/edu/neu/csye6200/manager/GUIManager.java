package edu.neu.csye6200.manager;

import com.formdev.flatlaf.FlatIntelliJLaf;
import edu.neu.csye6200.controller.ApplicationFormController;

public enum GUIManager {
	INSTANCE;
	public static GUIManager getInstance()
	{
		return INSTANCE;
	}

	public ApplicationFormController getController() {
		return controller;
	}
	private ApplicationFormController controller;

	GUIManager()
	{
		if (System.getProperty("os.name", "").startsWith("Mac OS")) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("apple.awt.textantialiasing", "true");
		}
		FlatIntelliJLaf.install();
		controller = new ApplicationFormController();
	}

	public void show()
	{
		controller.show();
	}
}
