package businessLogic;

import java.util.List;

/**
 * Created by Dion on 1/10/2017.
 */
public class BusinessRule {
    private String triggeringEvent;
    private String triggerCode;
    private String constraintStatement;
    private BusinessRuleType businessRuleType;
    private List<Operator> operators;
    private List<FailureHandling> errors;

    public BusinessRule(String triggeringEvent, String triggerCode, String constraintStatement, BusinessRuleType businessRuleType) {
        this.triggeringEvent = triggeringEvent;
        this.triggerCode = triggerCode;
        this.constraintStatement = constraintStatement;
        this.businessRuleType = businessRuleType;
    }
}
