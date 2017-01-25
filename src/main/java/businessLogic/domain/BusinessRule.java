package businessLogic.domain;

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

    private static List<BusinessRule> rules = new ArrayList<>();

    protected static void addRule(BusinessRule rule){
        rules.add(rule);
    }

    public static List<BusinessRule> getRules(){
        return rules;
    }

    public static BusinessRule getRule(int id){
        for (BusinessRule r : rules) {
            if(r.getRuleID() == id) return r;
        }
        return null;
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
