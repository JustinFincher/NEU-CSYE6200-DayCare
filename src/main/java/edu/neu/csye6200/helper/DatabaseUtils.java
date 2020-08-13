package edu.neu.csye6200.helper;

import edu.neu.csye6200.helper.annotation.DatabaseField;
import edu.neu.csye6200.helper.annotation.DatabaseTable;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.function.Consumer;

public class DatabaseUtils {

    public static boolean isDataBaseObject(Class<?> cls)
    {
        return cls.isAnnotationPresent(DatabaseTable.class);
    }
    public static boolean isDataBaseObject(Object obj)
    {
        return isDataBaseObject(obj.getClass());
    }
    @Nullable
    public static DatabaseTable getDatabaseTable(Class<?> cls)
    {
        if (isDataBaseObject(cls))
        {
            return cls.getAnnotation(DatabaseTable.class);
        }
        return null;
    }
    public static boolean isDataBaseField(Field field)
    {
        return field.isAnnotationPresent(DatabaseField.class);
    }
    @Nullable
    public static DatabaseField getDatabaseField(Field field)
    {
        if (isDataBaseObject(field))
        {
            return field.getAnnotation(DatabaseField.class);
        }
        return null;
    }
    public static String getCreateTableQuery(Class<?> cls)
    {
        if (isDataBaseObject(cls))
        {
            DatabaseTable tableAnnotation = getDatabaseTable(cls);
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE IF NOT EXISTS ");
            sb.append(tableAnnotation.tableName());
            sb.append("\n(\n");
            Iterator<Field> iterator = ReflectionUtils.getAllFields(cls).iterator();
            while (iterator.hasNext()) {
                Field f = iterator.next();
                DatabaseField fieldAnnotation = getDatabaseField(f);
                sb.append(fieldAnnotation.fieldName());
                sb.append(" ");
                sb.append(fieldAnnotation.fieldType().name());
                if (iterator.hasNext()) {
                    sb.append(",\n");
                }
            }
            sb.append(")");
            return sb.toString();
        }
        return null;
    }

    /**
     * Reference: https://www.sqlite.org/datatype3.html
     * @param field java field
     * @return the corresponding type in SQLite
     */
    public static String getFieldTypeQuery(Field field)
    {
        if (isDataBaseField(field))
        {
            DatabaseField fieldAnnotation = getDatabaseField(field);
            return fieldAnnotation.fieldType().name();
        }
        return null;
    }
}
