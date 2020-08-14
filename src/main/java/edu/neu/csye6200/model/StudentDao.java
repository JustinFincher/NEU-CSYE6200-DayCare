package edu.neu.csye6200.model;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;

@RegisterBeanMapper(Student.class)
public interface StudentDao extends CrudDao<Student>
{

}
