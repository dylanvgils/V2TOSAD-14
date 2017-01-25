package persistence.domain;


import businessLogic.domain.Table;

import java.util.List;

public interface TableDAO {
    List<Table> getByBusinessRuleID(int ruleID);
}
