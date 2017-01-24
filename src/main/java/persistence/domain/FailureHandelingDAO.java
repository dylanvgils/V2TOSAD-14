package persistence.domain;

import businessLogic.domain.FailureHandling;

public interface FailureHandelingDAO {
    FailureHandling getByBusinessRuleID(String ruleID);
}
