package edu.neu.csye6200.helper;

import edu.neu.csye6200.helper.annotation.JavaBeansIgnore;

import java.beans.*;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class BeanUtils
{
    public static List<String> getBeanPropertyNames(Class<?> cls)
    {
        return getBeanProperties(cls).stream().map(FeatureDescriptor::getName).collect(Collectors.toCollection(Vector::new));
    }

    public static List<PropertyDescriptor> getBeanProperties(Class<?> cls)
    {
        BeanInfo info = null;
        PropertyDescriptor[] pds = new PropertyDescriptor[0];
        try {
            info = Introspector.getBeanInfo(cls);
            pds = info.getPropertyDescriptors();
            return Arrays.stream(pds)
                    .filter(d -> !d.getName().equals("class"))
                    .filter(d -> d.getWriteMethod() != null && d.getReadMethod() != null)
                    .filter(d -> !d.getReadMethod().isAnnotationPresent(JavaBeansIgnore.class) || !d.getWriteMethod().isAnnotationPresent(JavaBeansIgnore.class))
                    .collect(Collectors.toCollection(Vector::new));
        } catch (IntrospectionException e) {
            Log.e(e.toString());
            e.printStackTrace();
        }
        return new Vector<>();
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
