package edu.neu.csye6200.model;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlScript;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface TeacherDao
{
    @SqlUpdate("CREATE TABLE IF NOT EXISTS teacher (id INTEGER PRIMARY KEY AUTOINCREMENT, credits INTEGER, user_name TEXT, real_name TEXT, user_level INTEGER)")
    void createTable();

    @SqlScript("CREATE TABLE IF NOT EXISTS teacher (<sql>)")
    void createTable(@Define("sql") String sql);

    @SqlQuery("SELECT * FROM teacher")
    @RegisterBeanMapper(Teacher.class)
    List<Teacher> listTeachers();

    @SqlQuery("SELECT * FROM teacher where id = ?")
    @RegisterBeanMapper(Teacher.class)
    Teacher findTeacher(Integer id);

    @SqlUpdate("INSERT INTO teacher(id, user_name) VALUES (:id, :userName)")
    void insertTeacher(@BindBean Teacher teacher);

    @SqlScript("INSERT INTO teacher(<key>) VALUES (<value>)")
    void insertTeacher(@Define("key") String key, @Define("value") String value);

    @SqlScript("UPDATE teacher SET <keyValuePairs> where id = <id>")
    void updateTeacher(@Define("keyValuePairs") String keyValuePairs, @Define("id") Integer id);
}
