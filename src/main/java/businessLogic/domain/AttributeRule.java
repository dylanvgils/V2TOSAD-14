package businessLogic.domain;

import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class AttributeRule extends BusinessRule {

    public static void initAttributeRule(){
        createRule(1, "name", "operator");
        createRule(2, "name", "operator");
        createRule(3, "name", "operator");
    }

    public static AttributeRule createRule(int ruleID, String name, String operator){
//        AttributeRule newRule = new AttributeRule(ruleID, name, operator);
//        addRule(newRule);
//        return newRule;
        return null;
    }

    public AttributeRule(int ruleID, String name, String operator, BusinessRuleType type, FailureHandling error) {
        super(ruleID, name, operator, type, error);
    }

    @Override
    public List<Attribute> getAttributes() {
        return super.attributes;
    }

    @Override
    public Column getColumns() {
        return (Column)super.columns.get(0);
    }

    @Override
    public Table getTables() {
        return (Table)super.tables.get(0);
    }


}
