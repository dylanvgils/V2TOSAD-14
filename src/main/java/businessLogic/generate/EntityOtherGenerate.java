package businessLogic.generate;

import businessLogic.domain.EntityRule;
import businessLogic.domain.InterEntityRule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by Dion on 1/27/2017.
 */
public class EntityOtherGenerate extends Generate<EntityRule> {

    public String generateRule(String lang, EntityRule rule){
        STGroup stGroup = new STGroupFile(getClass().getClassLoader().getResource(lang.toLowerCase() + "/EntityOtherRule.stg").getFile());

        String triggerType = rule.getTriggerType();
        ST templateEntityOther = stGroup.getInstanceOf("templateTrigger"+triggerType);
        templateEntityOther.add("ruleID", rule.getRuleID());
        templateEntityOther.add("ruleType", rule.getBusinessRuleType().getCode());
        templateEntityOther.add("application", "x");
        templateEntityOther.add("table", rule.getTables().getName());
        templateEntityOther.add("column", rule.getColumns().get(0).getName());
        templateEntityOther.add("columnOther", rule.getColumns().get(1).getName());
        templateEntityOther.add("attribute", rule.getValueByKey("max"));
        templateEntityOther.add("attribute", rule.getValueByKey("operator"));
        templateEntityOther.add("operator", rule.getOperator().toUpperCase());
        templateEntityOther.add("error_code", rule.getError().getErrorCode());
        templateEntityOther.add("error", rule.getError().getMessage());
        return templateEntityOther.render();
    }
}
