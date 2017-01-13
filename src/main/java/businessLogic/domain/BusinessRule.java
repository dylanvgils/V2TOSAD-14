package businessLogic.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class BusinessRule {

    private int ruleID;
    private String name;
    private String operator;
    private BusinessRuleType type;
    private FailureHandling error;

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

    public int getRuleID() {
        return ruleID;
    }
}
