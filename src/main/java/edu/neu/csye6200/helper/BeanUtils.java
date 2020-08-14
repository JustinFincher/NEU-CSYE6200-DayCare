package edu.neu.csye6200.helper;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeanUtils
{
    public static List<PropertyDescriptor> getBeanProperties(Class<?> cls)
    {
        BeanInfo info = null;
        PropertyDescriptor[] pds = new PropertyDescriptor[0];
        try {
            info = Introspector.getBeanInfo(cls);
            pds = info.getPropertyDescriptors();
        } catch (IntrospectionException e) {
            Log.e(e.toString());
            e.printStackTrace();
        }
        return Arrays.stream(pds).filter(d -> !d.getName().equals("class")).collect(Collectors.toList());
    }

    public static void printBeanProperties(Class<?> cls)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getCanonicalName()).append(" as Bean:\n").append("{\n");
        getBeanProperties(cls).forEach(propertyDescriptor ->
        {
            String name = propertyDescriptor.getName();
            Class<?> returnType = propertyDescriptor.getReadMethod().getReturnType();
            sb.append("\t")
                    .append(name)
                    .append(" -> ")
                    .append(returnType.getCanonicalName())
                    .append("\n");
        });
        sb.append("}");
        Log.i(sb.toString());
    }


}
