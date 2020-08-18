package edu.neu.csye6200.manager;

import edu.neu.csye6200.helper.Log;
import edu.neu.csye6200.helper.SQLUtils;
import edu.neu.csye6200.model.*;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.array.SqlArrayType;
import org.jdbi.v3.core.mapper.ColumnMapper;
import org.jdbi.v3.core.mapper.reflect.ReflectionMappers;
import org.jdbi.v3.core.statement.SqlLogger;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.sqlite3.SQLitePlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

	public File getFile() { return new File(DatabaseManager.getInstance().getPath()); }
	public String getPath() { return path; }
	private String path;
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
		this.path = path;
		Log.i("DatabaseManager.use(" + path + ")");
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:"+path);
			jdbi = Jdbi.create(connection).installPlugin(new SqlObjectPlugin()).installPlugin(new SQLitePlugin());
			jdbi.getConfig(ReflectionMappers.class).setStrictMatching(false);
			jdbi.onDemand(TeacherDao.class).createTable(Teacher.class);
			if (jdbi.onDemand(TeacherDao.class).isTableEmpty(Teacher.class))
			{
				jdbi.onDemand(TeacherDao.class).insertRootUser();
			}
			jdbi.onDemand(StudentDao.class).createTable(Student.class);
			jdbi.onDemand(ParentDao.class).createTable(Parent.class);
			jdbi.onDemand(RatioRuleDao.class).createTable(RatioRule.class);
			jdbi.setSqlLogger(new SqlLogger() {
				@Override
				public void logBeforeExecution(StatementContext context) {
					StringBuilder sb = new StringBuilder();
					sb.append("SQL Before Execution:").append("\n");
					sb.append("\t").append("[RAWSQL] ").append(context.getRawSql()).append(" ").append(context.getBinding().toString()).append("\n");
					sb.append("\t").append("[RENDER] ").append(context.getRenderedSql()).append("\n");
					Log.i(sb.toString());
				}
			});
		} catch (SQLException throwable) {
			Log.e(throwable.getMessage());
			throwable.printStackTrace();
		}
		Log.i("DatabaseManager connection " + (connection != null ? "established" : "lost"));
	}
}
