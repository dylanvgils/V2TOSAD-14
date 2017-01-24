package persistence.domain;

import businessLogic.domain.Column;

public interface ColumnDAO {
    Column getByBusinessRuleID(String ruleID);
}
