package edu.neu.csye6200.model;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;

@RegisterBeanMapper(Classroom.class)
public interface ClassroomDao extends CrudDao<Classroom>
{
    default void fillGroupsOfClassroom()
    {

    }
}
