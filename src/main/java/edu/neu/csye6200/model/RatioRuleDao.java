package edu.neu.csye6200.model;

import edu.neu.csye6200.manager.DatabaseManager;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;

@RegisterBeanMapper(RatioRule.class)
public interface RatioRuleDao extends CrudDao<RatioRule> {
    RatioRuleDao dao = DatabaseManager.getDB().onDemand(RatioRuleDao.class);
    dao.list();

}
