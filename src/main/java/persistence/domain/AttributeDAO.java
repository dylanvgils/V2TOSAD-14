package persistence.domain;

import businessLogic.domain.Attribute;

public interface AttributeDAO {
    Attribute getByBusinessRuleID(String ruleID);
}
