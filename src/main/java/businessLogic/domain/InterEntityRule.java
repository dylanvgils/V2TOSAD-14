package businessLogic.domain;

import java.util.List;

/**
 * Created by Dion on 1/27/2017.
 */
public class InterEntityRule extends BusinessRule {
    public InterEntityRule(int ruleID, String name, String application, String operator, String triggerType, BusinessRuleType type, FailureHandling error) {
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
    public List<Table> getTables() {
        return super.tables;
    }
}
