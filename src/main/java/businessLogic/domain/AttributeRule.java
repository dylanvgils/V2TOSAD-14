package businessLogic.domain;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class AttributeRule extends BusinessRule {
    private List<Attribute> attributes = new ArrayList<>();
    private Column column;
    private Table table;

    public static AttributeRule createRule(int ruleID, String name, String operator, BusinessRuleType type, FailureHandling error){
        AttributeRule newRule = new AttributeRule(ruleID, name, operator, type, error);
        addRule(newRule);
        return newRule;
    }

    public AttributeRule(int ruleID, String name, String operator, BusinessRuleType type, FailureHandling error) {
        super(ruleID, name, operator, type, error);
    }

    public void addAttribute(Attribute attribute){
        attributes.add(attribute);
    }

    public void setColumn(Column column){
        this.column = column;
    }

    public void setTable(Table table){
        this.table = table;
    }

    public Column getColumn() {
        return column;
    }

    public Table getTable() {
        return table;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }
}
