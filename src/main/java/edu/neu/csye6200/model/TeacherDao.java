package edu.neu.csye6200.model;

import edu.neu.csye6200.helper.SQLUtils;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;

import java.util.Optional;

@RegisterBeanMapper(Teacher.class)
public interface TeacherDao extends CrudDao<Teacher> {

    default Optional<Teacher> findByUserName(String name)
    {
        String tableName = SQLUtils.getTableName(Teacher.class);
        return getHandle().createQuery("SELECT * FROM <tableName> where user_name = :id")
                .define("tableName", tableName)
                .bind("user_name", name)
                .mapTo(Teacher.class)
                .stream().findFirst();
    }

    default void insertRootUser()
    {
        insert(new Teacher(){{
            setUserName("root");
            setPassword("password");
            setUserLevel(0);
        }}, Teacher.class);
    }
}
