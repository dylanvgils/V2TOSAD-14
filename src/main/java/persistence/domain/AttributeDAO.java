package persistence.domain;

import businessLogic.domain.Attribute;

import java.util.List;

public interface AttributeDAO {
    List<Attribute> getByBusinessRuleID(int ruleID);
}
