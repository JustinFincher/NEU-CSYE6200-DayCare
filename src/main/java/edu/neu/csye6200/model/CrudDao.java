package edu.neu.csye6200.model;

import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlScript;

import java.util.List;
import java.util.Optional;

/**
 *
 * CRUD DAO, a generic DAO class for all {@link DBObject DBObject} subclass <br>
 * How to use:<br>
 * <pre>
 * {@literal
 * // Let's say you have a subclass of CrudDao called PeopleDao:
 * (remember to add @RegisterBeanMapper(People.class) annotation on your Dao)
 * public interface PeopleDao extends CrudDao<People>
 * {
 * }
 *
 * // then:
 * PeopleDao dao = DatabaseManager.getDB().onDemand(PeopleDao.class);
 * // then you can call all base methods declared in <CrudDao>, like:
 * dao.createTable("people", "id INTEGER PRIMARY KEY");
 * // but most of the time you don't need to hard code SQL queries, as you can use <SQLUtils>:
 * dao.createTable(SQLUtils.getTableName(People.class), SQLUtils.getProperties(People.class));
 * }
 * </pre>
 *
 * @author Haotian Zheng
 * @see DBObject
 * @see DatabaseTableModel
 * @param <T> A placeholder for the data model class later to be specified
 */
public interface CrudDao<T extends DBObject>
{
    /**
     * Create a table in database if it does not exist
     * @param tableName table name, usually acquired via SQLUtils.getTableName(YourDataModel.class)
     * @param sql sql query for table properties, also with a helper method SQLUtils.getProperties(YourDataModel.class)
     */
    @SqlScript("CREATE TABLE IF NOT EXISTS <tableName> (<sql>)")
    void createTable(@Define("tableName") String tableName, @Define("sql") String sql);

    /**
     * Insert an entry into the database
     * @param tableName table name, usually acquired via SQLUtils.getTableName(YourDataModel.class)
     * @param keysAndValues usually acquired via SQLUtils.getKeysAndValues(model, false)
     */
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