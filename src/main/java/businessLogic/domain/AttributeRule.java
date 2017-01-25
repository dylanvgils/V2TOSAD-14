package businessLogic.domain;

import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class AttributeRule extends BusinessRule {
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
