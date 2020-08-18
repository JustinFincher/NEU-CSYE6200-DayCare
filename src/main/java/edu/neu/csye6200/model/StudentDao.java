package edu.neu.csye6200.model;

import edu.neu.csye6200.helper.SQLUtils;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;

import java.util.List;
import java.util.stream.Collectors;

@RegisterBeanMapper(Student.class)
public interface StudentDao extends CrudDao<Student>
{
    default List<Parent> getParents(Student student)
    {
        String tableName = SQLUtils.getTableName(Parent.class);
        return getHandle().createQuery("SELECT * FROM <tableName>")
                .define("tableName", tableName)
                .mapTo(Parent.class)
                .stream()
                .filter(p -> p.hasChild(student))
                .collect(Collectors.toList());
    }
}
