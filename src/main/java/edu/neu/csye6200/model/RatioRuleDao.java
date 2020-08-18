package edu.neu.csye6200.model;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;

/**
 * Usage example:<br>
 * To get a list of RatioRules:
 * <pre>
 * {@code
 *     DatabaseManager.getDB().onDemand(RatioRuleDao.class).list(SQLUtils.getTableName(RatioRule.class));
 * }
 * </pre>
 */
@RegisterBeanMapper(RatioRule.class)
public interface RatioRuleDao extends CrudDao<RatioRule> {


}
