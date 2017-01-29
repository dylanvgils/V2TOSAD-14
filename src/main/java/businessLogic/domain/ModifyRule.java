package businessLogic.domain;

import java.util.List;

/**
 * Created by Dion on 1/27/2017.
 */
public class ModifyRule extends BusinessRule {

    public ModifyRule(int ruleID, String name, String operator, String triggerType, BusinessRuleType type, FailureHandling error){
        super(ruleID, name, operator, triggerType, type, error);
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
