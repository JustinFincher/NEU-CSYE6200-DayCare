package edu.neu.csye6200.model;

import edu.neu.csye6200.helper.Log;
import edu.neu.csye6200.helper.SQLUtils;
import org.jdbi.v3.sqlobject.SqlObject;
import org.jdbi.v3.sqlobject.customizer.Define;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.*;
import java.util.stream.Collectors;

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
public interface CrudDao<T extends DBObject> extends SqlObject
{
    /**
     * Create a table in database if it does not exist
     * @param tableName table name, usually acquired via SQLUtils.getTableName(YourDataModel.class)
     * @param sql sql query for table properties, also with a helper method SQLUtils.getProperties(YourDataModel.class)
     */
    @SqlUpdate("CREATE TABLE IF NOT EXISTS <tableName> (<sql>)")
    void createTable(@Define("tableName") String tableName, @Define("sql") String sql);
    default void createTable(Class<T> className)
    {
        getHandle().createUpdate("CREATE TABLE IF NOT EXISTS <tableName> (<sql>)")
                .define("tableName", SQLUtils.getTableName(className))
                .define("sql", SQLUtils.getAllKeysInString(className))
                .execute();
    }

    /**
     * Insert an entry into the database
     * @param tableName table name, usually acquired via SQLUtils.getTableName(YourDataModel.class)
     * @param keysAndValues usually acquired via SQLUtils.getKeysAndValues(model, false)
     */
    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO <tableName> <keysAndValues>")
    int insert(@Define("tableName") String tableName, @Define("keysAndValues") String keysAndValues);

    default void insert(T object, Class<T> className)
    {
        String tableName = SQLUtils.getTableName(className);
        String bindings = SQLUtils.getKeysAndValueBindingsInCreateString(object, false);
        Map<String, ?> map = SQLUtils.getKeysAndValuesInMap(object, false);
        try {
            getHandle().createUpdate("INSERT INTO <tableName> " + bindings)
                    .define("tableName", tableName)
                    .bindMap(map)
                    .execute();
        }catch (Exception e)
        {
            Log.e(e.getMessage());
            e.printStackTrace();
        }
    }

    @SqlQuery("SELECT * FROM <tableName> where id = ?")
    Optional<T> findById(@Define("tableName") String tableName, Integer id);
    default T find(Class<T> className, Integer id)
    {
        String tableName = SQLUtils.getTableName(className);
        return getHandle().createQuery("SELECT * FROM <tableName> where id = :id")
                .define("tableName", tableName)
                .bind("id", id)
                .mapTo(className)
                .one();
    }

    @SqlQuery("SELECT * FROM <tableName>")
    List<T> list(@Define("tableName") String tableName);

    default List<T> list(Class<T> className)
    {
        String tableName = SQLUtils.getTableName(className);
        return getHandle().createQuery("SELECT * FROM <tableName>")
                .define("tableName", tableName)
                .mapTo(className)
                .list();
    }

    default boolean isTableEmpty(Class<T> className)
    {
        return list(className).isEmpty();
    }

    @SqlUpdate("UPDATE <tableName> SET <keyValuePairs> WHERE id = <id>")
    void update(@Define("tableName") String tableName, @Define("keyValuePairs") String keyValuePairs, @Define("id") Integer id);

    default void update(T object, Class<T> className)
    {
        String tableName = SQLUtils.getTableName(className);
        String bindings = SQLUtils.getKeysAndValueBindingsInUpdateString(object, false);
        Map<String, ?> map = SQLUtils.getKeysAndValuesInMap(object, false);
        String query = "UPDATE <tableName> SET " + bindings + " WHERE id = :id";
        getHandle().createUpdate(query)
                .define("tableName", tableName)
                .bindMap(map)
                .bind("id", object.getId())
                .execute();
    }

    @SqlUpdate("DELETE FROM <tableName> WHERE id = <id>")
    void deleteById(@Define("tableName") String tableName, @Define("id") Integer id);

    default void reset(Class<T> className)
    {
        String tableName = SQLUtils.getTableName(className);
        getHandle().createUpdate("DROP TABLE <tableName>")
                .define("tableName", tableName)
                .execute();
        createTable(className);
    }

    default void importCSV(String fileContent, Class<T> className)
    {
        String[] lines = fileContent.split("\\r?\\n");
        if (lines.length <= 1) return;
        String keyLine = lines[0];
        String[] keys = keyLine.split(",");
        Arrays.stream(lines).skip(1).forEach(s -> {
            String[] values = s.split(",");
            if (keys.length != values.length)
            {
                return;
            }
            try {
                T obj = className.newInstance();
                Map<String, String> map = new HashMap<>();
                for (int i=0; i < keys.length; i++) {
                    map.put(keys[i], values[i]);
                }
                obj.loadCsv(map);
                insert(obj, className);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    default String exportCSV(Class<T> className)
    {
        List<String> keysList = SQLUtils.getAllKeysInList(className, false);
        String keys = String.join(",", keysList);
        StringBuilder sb = new StringBuilder(keys).append("\n");
        Iterator<T> iterator = list(className).iterator();
        while (iterator.hasNext())
        {
            T obj = iterator.next();
            Map<String, ?> strToObjMap = SQLUtils.getKeysAndValuesInMap(obj, false);
            Map<String, String> strToStrMap = new HashMap<>();
            strToObjMap.keySet().forEach(s -> strToStrMap.put(s, ""));
            obj.saveCsv(strToStrMap);
            String values = keysList.stream().map(strToStrMap::get).collect(Collectors.joining(","));
            sb.append(values);
            if (iterator.hasNext())
            {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}