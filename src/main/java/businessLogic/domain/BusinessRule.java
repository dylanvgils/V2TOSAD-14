package businessLogic.domain;

import persistence.PersistenceDomainFacade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public abstract class BusinessRule<X> {

    private int ruleID;
    private String name;
    private String application;
    private String operator;
    private String triggerType;
    private BusinessRuleType type;
    private FailureHandling error;
    protected List<Attribute> attributes = new ArrayList<>();
    protected List<Column> columns = new ArrayList<>();
    protected List<Table> tables = new ArrayList<>();

    public static BusinessRule getRule(int ruleID) {
        return PersistenceDomainFacade.getBusinessRule(ruleID);
    }


    public BusinessRule(int ruleID, String name, String application, String operator, String triggerType, BusinessRuleType type, FailureHandling error) {
        this.ruleID = ruleID;
        this.name = name;
        this.application = application;
        this.operator = operator;
        this.triggerType = triggerType;
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
            if(a.getKey().equalsIgnoreCase(key)){
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

    public String getTriggerType() {
        return triggerType;
    }

    public BusinessRuleType getBusinessRuleType(){
        return type;
    }

    public String getApplication(){
        return application;
    }
}
