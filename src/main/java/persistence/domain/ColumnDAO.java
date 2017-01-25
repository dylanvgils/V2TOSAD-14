package persistence.domain;

import businessLogic.domain.Column;

import java.util.List;

public interface ColumnDAO {
    List<Column> getByBusinessRuleID(int ruleID);
}
