package edu.neu.csye6200.model;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;

@RegisterBeanMapper(ClassroomGroup.class)
public interface ClassroomGroupDao extends CrudDao<ClassroomGroup>
{

}