package persistence;

import businessLogic.domain.*;
import persistence.domain.*;

import java.util.List;

public class PersistenceDomainFacade {
    private static final BusinessRuleTypeDAO businessRuleType = new BusinessRuleTypeImpl();
    private static final FailureHandelingDAO failureHandeling = new FailureHandelingImpl();
    private static final AttributeDAO attribute = new AttributeImpl();
    private static final ColumnDAO column = new ColumnImpl();
    private static final TableDAO table = new TableImpl();

    public static BusinessRuleType getBusinessRuleType(int typeID) {
        return businessRuleType.getBusinessRuleTypeByID(typeID);
    }

    public static FailureHandling getFailureHandeling(int failureID) {
        return failureHandeling.getFailureHandelingByID(failureID);
    }

    public static List<Attribute> getAttributes(int ruleID) {
        return attribute.getByBusinessRuleID(ruleID);
    }

    public static List<Table> getTables(int ruleID) {
        return table.getByBusinessRuleID(ruleID);
    }

    public static List<Column> getColumns(int ruleID) {
        return column.getByBusinessRuleID(ruleID);
    }
}
