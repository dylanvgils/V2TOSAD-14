package persistence.domain;

import businessLogic.domain.BusinessRule;

public interface BusinessRuleDAO {
    BusinessRule getBusinessRuleByRuleID(String ruleID);
}
