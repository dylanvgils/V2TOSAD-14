package persistence.domain;

import businessLogic.domain.FailureHandling;
import persistence.BaseDAO;

public class FailureHandelingImpl extends BaseDAO implements FailureHandelingDAO {
    @Override
    public FailureHandling getByBusinessRuleID(String ruleID) {
        return null;
    }
}
