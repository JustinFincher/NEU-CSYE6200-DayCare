package edu.neu.csye6200.model;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;

@RegisterBeanMapper(Parent.class)
public interface ParentDao extends CrudDao<Parent>
{

}
