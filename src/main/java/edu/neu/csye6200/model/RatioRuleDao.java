package edu.neu.csye6200.model;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;

@RegisterBeanMapper(RatioRule.class)
public interface RatioRuleDao extends CrudDao<RatioRule> {
}
