package edu.neu.csye6200.model;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlScript;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T>
{
    @SqlScript("CREATE TABLE IF NOT EXISTS <tableName> (<sql>)")
    void createTable(@Define("tableName") String tableName, @Define("sql") String sql);

    @SqlUpdate
    void insert(@BindBean T entity);

    @SqlQuery("SELECT * FROM <tableName> where id = ?")
    Optional<T> findById(@Define("tableName") String tableName, Integer id);

    @SqlQuery("SELECT * FROM <tableName>")
    List<T> list(@Define("tableName") String tableName);

    @SqlScript("UPDATE <tableName> SET <keyValuePairs> where id = <id>")
    void update(@Define("tableName") String tableName, @Define("keyValuePairs") String keyValuePairs, @Define("id") Integer id);

    @SqlUpdate
    void deleteById(Integer id);
}