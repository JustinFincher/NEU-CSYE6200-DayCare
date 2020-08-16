package edu.neu.csye6200.helper;

import com.google.common.base.CaseFormat;
import edu.neu.csye6200.model.DBObject;
import org.sqlite.core.DB;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class SQLUtils
{
    public static String getProperties(Class<? extends DBObject> cls)
    {
        StringBuilder sb = new StringBuilder();
        Iterator<PropertyDescriptor> iterator = BeanUtils.getBeanProperties(cls).iterator();
        while (iterator.hasNext()) {
            PropertyDescriptor propertyDescriptor = iterator.next();
            String name = propertyDescriptor.getName();
            String dbKey = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
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

    public static <T extends DBObject> String getKeysAndValues(T obj, boolean includeId)
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
            Object o = null;
            try {
                o = propertyDescriptor.getReadMethod().invoke(obj);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            if (!dbKey.equals("id") || includeId)
            {
                keys.append(dbKey);
                values.append(o);
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

    public static <T extends DBObject> String getKeyValuePairs(T obj, boolean includeId)
    {
        StringBuilder sb = new StringBuilder();
        Iterator<PropertyDescriptor> iterator = BeanUtils.getBeanProperties(obj.getClass()).iterator();
        while (iterator.hasNext()) {
            PropertyDescriptor propertyDescriptor = iterator.next();
            String name = propertyDescriptor.getName();
            String dbKey = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
            Object o = null;
            try {
                o = propertyDescriptor.getReadMethod().invoke(obj);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            if (!dbKey.equals("id") || includeId)
            {
                sb.append(dbKey);
                sb.append(" = ");
                sb.append('\'').append(o).append('\'');
                if (iterator.hasNext()) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }

    public static String getKeyValuePair(PropertyDescriptor propertyDescriptor, Object newValue)
    {
        StringBuilder sb = new StringBuilder();
        String name = propertyDescriptor.getName();
        String dbKey = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
        sb.append(dbKey);
        sb.append(" = ");
        sb.append('\'').append(newValue).append('\'');
        return sb.toString();
    }

    public static String getTableName(Class<? extends DBObject> cls)
    {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, cls.getSimpleName());
    }

    public static String getType(String name, Class<?> cls)
    {
        String res = name;
        String append;
        switch (cls.getSimpleName())
        {
            case "Integer":
                append = "INTEGER"; break;
            case "String":
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
