package businessLogic.domain;

import persistence.PersistenceDomainFacade;
import persistence.domain.AttributeImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public abstract class BusinessRule<X> {

    private int ruleID;
    private String name;
    private String operator;
    private BusinessRuleType type;
    private FailureHandling error;
    protected List<Attribute> attributes = new ArrayList<>();
    protected List<Column> columns = new ArrayList<>();
    protected List<Table> tables = new ArrayList<>();

    public static BusinessRule getRule(int ruleID) {
        return PersistenceDomainFacade.getBusinessRule(ruleID);
    }


    public BusinessRule(int ruleID, String name, String operator, BusinessRuleType type, FailureHandling error) {
        this.ruleID = ruleID;
        this.name = name;
        this.operator = operator;
        this.type = type;
        this.error = error;
    }


    public int getRuleID() {
        return ruleID;
    }

    public String getName() {
        return name;
    }

    public String getOperator() {
        return operator;
    }

    public BusinessRuleType getType() {
        return type;
    }

    public FailureHandling getError() {
        return error;
    }

    public String getValueByKey(String key){
        for (Attribute a : attributes) {
            if(a.getKey() == key){
                return a.getValue();
            }
        }
        return null;

    }

    public abstract X getAttributes();

    public abstract X getColumns();

    public abstract X getTables();

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public void setType(BusinessRuleType type) {
        this.type = type;
    }

    public void setError(FailureHandling error) {
        this.error = error;
    }
}
