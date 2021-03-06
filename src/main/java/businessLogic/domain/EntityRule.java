package businessLogic.domain;

import java.util.List;

/**
 * Created by Dion on 1/27/2017.
 */
public class EntityRule extends BusinessRule {
    public EntityRule(int ruleID, String name, String application, String operator, String triggerType, BusinessRuleType type, FailureHandling error) {
        super(ruleID, name, application, operator, triggerType, type, error);
    }

    @Override
    public List<Attribute> getAttributes() {
        return super.attributes;
    }

    @Override
    public List<Column> getColumns() {
        return super.columns;
    }

    @Override
    public Table getTables() {
        return (Table)super.tables.get(0);
    }
}
