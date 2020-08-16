package edu.neu.csye6200.model;

import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlScript;

import java.util.List;
import java.util.Optional;

/**
 * CRUD DAO, a base class for all
 * @param <T>
 */
public interface CrudDao<T>
{
    @SqlScript("CREATE TABLE IF NOT EXISTS <tableName> (<sql>)")
    void createTable(@Define("tableName") String tableName, @Define("sql") String sql);

    @SqlScript("INSERT INTO <tableName> <keysAndValues>")
    void insert(@Define("tableName") String tableName, @Define("keysAndValues") String keysAndValues);

    @SqlQuery("SELECT * FROM <tableName> where id = ?")
    Optional<T> findById(@Define("tableName") String tableName, Integer id);

    @SqlQuery("SELECT * FROM <tableName>")
    List<T> list(@Define("tableName") String tableName);

    @SqlScript("UPDATE <tableName> SET <keyValuePairs> WHERE id = <id>")
    void update(@Define("tableName") String tableName, @Define("keyValuePairs") String keyValuePairs, @Define("id") Integer id);

    @SqlScript("DELETE FROM <tableName> WHERE id = <id>")
    void deleteById(@Define("tableName") String tableName, @Define("id") Integer id);
}