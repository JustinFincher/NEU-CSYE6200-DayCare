package edu.neu.csye6200.manager;

import com.formdev.flatlaf.FlatIntelliJLaf;

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

	}
}
