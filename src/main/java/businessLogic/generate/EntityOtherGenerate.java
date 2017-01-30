package businessLogic.generate;

import businessLogic.domain.EntityRule;
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
        templateEntityOther.add("application", rule.getApplication());
        String[] split = rule.getTables().getName().split("_");
        templateEntityOther.add("short_table", split[1].substring(0, Math.min(split[1].length(), 3)));
        templateEntityOther.add("table", rule.getTables().getName());
        templateEntityOther.add("column", rule.getColumns().get(0).getName());
        templateEntityOther.add("columnOther", rule.getColumns().get(1).getName());
        templateEntityOther.add("attribute", rule.getValueByKey("max"));
        templateEntityOther.add("attrOperator", Generate.getOperator(lang, rule.getValueByKey("operator")));
        templateEntityOther.add("function", Generate.getOperator(lang, rule.getValueByKey("function")));
        templateEntityOther.add("operator", Generate.getOperator(lang, rule.getOperator()));
        templateEntityOther.add("error_code", rule.getError().getErrorCode());
        templateEntityOther.add("error", rule.getError().getMessage());
        return templateEntityOther.render();
    }
}
