package businessLogic;

import java.util.List;

/**
 * Created by Dion on 1/10/2017.
 */
public class BusinessRule {
    private String name;
    private BusinessRuleType businessRuleType;
    private List<Operator> operators;
    private List<FailureHandling> errors;

    public BusinessRule(String name, BusinessRuleType businessRuleType) {
        this.name = name;
        this.businessRuleType = businessRuleType;
    }

    public void addOperator(Operator operator) {
        this.operators.add(operator);
    }
}
