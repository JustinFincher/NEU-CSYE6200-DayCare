package edu.neu.csye6200.manager;

import edu.neu.csye6200.helper.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DatabaseManager {
	INSTANCE;
	public static DatabaseManager getInstance()
	{
		return INSTANCE;
	}

	DatabaseManager()
	{

	}

	private Connection connection;
	public void use(String path)
	{
		Log.i("DatabaseManager.use(" + path + ")");
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:"+path);
		} catch (SQLException throwable) {
			Log.e(throwable.getMessage());
			throwable.printStackTrace();
		}
		Log.i("DatabaseManager connection " + (connection != null ? "established" : "lost"));
	}
}
