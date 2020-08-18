package edu.neu.csye6200.helper;

import com.google.common.base.CaseFormat;
import com.google.common.base.Function;
import edu.neu.csye6200.model.DBObject;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SQLUtils
{
    public static String getKeyInString(String str)
    {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    }
    public static String getKeyInString(PropertyDescriptor descriptor)
    {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, descriptor.getName());
    }

    public static String getAllKeysInString(Class<? extends DBObject> cls)
    {
        StringBuilder sb = new StringBuilder();
        Iterator<PropertyDescriptor> iterator = BeanUtils.getBeanProperties(cls).iterator();
        while (iterator.hasNext()) {
            PropertyDescriptor propertyDescriptor = iterator.next();
            String dbKey = getKeyInString(propertyDescriptor);
            Class<?> returnType = propertyDescriptor.getReadMethod().getReturnType();
            String sql = getType(dbKey, returnType);
            if (!sql.isEmpty())
            {
                sb.append(sql);
                if (iterator.hasNext()) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }

    public static List<String> getAllKeysInList(Class<? extends DBObject> cls, boolean includeId)
    {
        Stream<String> stream = BeanUtils.getBeanProperties(cls).stream().map(SQLUtils::getKeyInString);
        if (!includeId)
        {
            stream = stream.filter(s -> !s.equals("id"));
        }
        return stream.collect(Collectors.toList());
    }

    public static <T extends DBObject> Map<String, ?> getKeysAndValuesInMap(T obj, boolean includeId)
    {
        Stream<PropertyDescriptor> stream = BeanUtils.getBeanProperties(obj.getClass()).stream();
        if (!includeId) {
            stream = stream.filter(d -> !d.getName().equals("id"));
        }
        return stream.collect(HashMap::new, (m, v) -> {
            try {
                m.put(SQLUtils.getKeyInString(v), v.getReadMethod().invoke(obj));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }, HashMap::putAll);
    }

    public static <T extends DBObject> String getKeysAndValueBindingsInCreateString(T obj, boolean includeId)
    {
        StringBuilder keys = new StringBuilder();
        StringBuilder values = new StringBuilder();
        Iterator<PropertyDescriptor> iterator = BeanUtils.getBeanProperties(obj.getClass()).iterator();
        keys.append("(");
        values.append("VALUES(");
        while (iterator.hasNext()) {
            PropertyDescriptor propertyDescriptor = iterator.next();
            String name = propertyDescriptor.getName();
            String dbKey = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
            if (!dbKey.equals("id") || includeId)
            {
                keys.append(dbKey);
                values.append(":").append(dbKey);
                if (iterator.hasNext()) {
                    keys.append(", ");
                    values.append(", ");
                }
            }
        }
        keys.append(")");
        values.append(")");
        return keys.append(" ").append(values).toString();
    }

    public static <T extends DBObject> String getKeysAndValueBindingsInUpdateString(T obj, boolean includeId)
    {
        return getAllKeysInList(obj.getClass(), includeId)
                .stream()
                .map((Function<String, String>) input -> input + " = :" + input)
                .collect(Collectors.joining(", "));
    }

//    public static <T extends DBObject> String getKeysAndValues(T obj, boolean includeId)
//    {
//        StringBuilder keys = new StringBuilder();
//        StringBuilder values = new StringBuilder();
//        Iterator<PropertyDescriptor> iterator = BeanUtils.getBeanProperties(obj.getClass()).iterator();
//        keys.append("(");
//        values.append("VALUES(");
//        while (iterator.hasNext()) {
//            PropertyDescriptor propertyDescriptor = iterator.next();
//            String name = propertyDescriptor.getName();
//            String dbKey = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
//            Object o = null;
//            try {
//                o = propertyDescriptor.getReadMethod().invoke(obj);
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//            if (!dbKey.equals("id") || includeId)
//            {
//                keys.append(dbKey);
//                values.append(o);
//                if (iterator.hasNext()) {
//                    keys.append(", ");
//                    values.append(", ");
//                }
//            }
//        }
//        keys.append(")");
//        values.append(")");
//        return keys.append(" ").append(values).toString();
//    }
//
//    public static <T extends DBObject> String getKeyValuePairs(T obj, boolean includeId)
//    {
//        StringBuilder sb = new StringBuilder();
//        Iterator<PropertyDescriptor> iterator = BeanUtils.getBeanProperties(obj.getClass()).iterator();
//        while (iterator.hasNext()) {
//            PropertyDescriptor propertyDescriptor = iterator.next();
//            String name = propertyDescriptor.getName();
//            String dbKey = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
//            Object o = null;
//            try {
//                o = propertyDescriptor.getReadMethod().invoke(obj);
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//            if (!dbKey.equals("id") || includeId)
//            {
//                sb.append(dbKey);
//                sb.append(" = ");
//                sb.append('\'').append(o).append('\'');
//                if (iterator.hasNext()) {
//                    sb.append(", ");
//                }
//            }
//        }
//        return sb.toString();
//    }
//
//    public static String getKeyValuePair(PropertyDescriptor propertyDescriptor, Object newValue)
//    {
//        StringBuilder sb = new StringBuilder();
//        String name = propertyDescriptor.getName();
//        String dbKey = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
//        sb.append(dbKey);
//        sb.append(" = ");
//        sb.append('\'').append(newValue).append('\'');
//        return sb.toString();
//    }

    public static String getTableName(Class<? extends DBObject> cls)
    {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, cls.getSimpleName());
    }

    /**
     * Get corresponding SQLite type from the Java type, with special prefix activated by the name<br>
     * For example: <br>
     * <pre>
     * id INTEGER PRIMARY KEY AUTOINCREMENT
     * </pre>
     * @param name
     * @param cls
     * @return SQLite Type in UPPER CASE
     */
    public static String getType(String name, Class<?> cls)
    {
        String res = name;
        String append;
        switch (cls.getSimpleName())
        {
            case "Integer":
            case "LocalDate":
            case "LocalDateTime":
                append = "INTEGER"; break;
            case "String":
            case "List":
                append = "TEXT"; break;
            default:
                append = "BLOB"; break;
        }
        res += " ";
        res += append;
        if ("id".equals(name)) {
            res += " PRIMARY KEY AUTOINCREMENT";
        }
        return res;
    }
}
