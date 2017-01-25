package persistence.domain;

import businessLogic.domain.BusinessRule;

public interface BusinessRuleDAO {
    BusinessRule getBusinessRuleByRuleID(int ruleID);
}
