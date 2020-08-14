package edu.neu.csye6200.manager;

import edu.neu.csye6200.helper.Log;
import edu.neu.csye6200.helper.SQLUtils;
import edu.neu.csye6200.model.*;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ReflectionMappers;
import org.jdbi.v3.sqlite3.SQLitePlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DatabaseManager {
	INSTANCE;
	public static DatabaseManager getInstance()
	{
		return INSTANCE;
	}
	public static Jdbi getDB()
	{
		return DatabaseManager.getInstance().getDataBase();
	}

	DatabaseManager()
	{
	}

	private Connection connection;
	public boolean isConnectionWorking()
	{
		try {
			return connection != null && !connection.isClosed();
		} catch (SQLException throwable) {
			throwable.printStackTrace();
		}
		return false;
	}
	private Jdbi jdbi;
	public Jdbi getDataBase()
	{
		return jdbi;
	}

	public void use(String path)
	{
		Log.i("DatabaseManager.use(" + path + ")");
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:"+path);
			jdbi = Jdbi.create(connection).installPlugin(new SqlObjectPlugin()).installPlugin(new SQLitePlugin());
			jdbi.getConfig(ReflectionMappers.class).setStrictMatching(false);

			jdbi.onDemand(TeacherDao.class).createTable();
			jdbi.onDemand(StudentDao.class).createTable(SQLUtils.getTableName(Student.class), SQLUtils.getProperties(Student.class));
			jdbi.onDemand(ParentDao.class).createTable(SQLUtils.getTableName(Parent.class), SQLUtils.getProperties(Parent.class));

		} catch (SQLException throwable) {
			Log.e(throwable.getMessage());
			throwable.printStackTrace();
		}
		Log.i("DatabaseManager connection " + (connection != null ? "established" : "lost"));
	}
}
