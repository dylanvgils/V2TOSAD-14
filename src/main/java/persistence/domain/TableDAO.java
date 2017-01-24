package persistence.domain;


import businessLogic.domain.Table;

public interface TableDAO {
    Table getByBusinessRuleID(String ruleID);
}
