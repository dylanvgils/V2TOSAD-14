package businessLogic.generate;

import businessLogic.domain.AttributeRule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by Dion on 1/22/2017.
 */
public class AttributeRangeGenerate extends Generate<AttributeRule> {

    public String generateRule(String lang, AttributeRule rule){
        STGroup stGroup = new STGroupFile(getClass().getClassLoader().getResource(lang.toLowerCase() + "/AttributeRangeRule.stg").getFile());

        String triggerType = rule.getTriggerType();
        ST templateAttributeRange = stGroup.getInstanceOf("templateTrigger"+triggerType);

        templateAttributeRange.add("ruleID", rule.getRuleID());
        templateAttributeRange.add("ruleType", rule.getBusinessRuleType().getCode());
        templateAttributeRange.add("application", rule.getApplication());
        templateAttributeRange.add("table", rule.getTables().getName());
        templateAttributeRange.add("column", rule.getColumns().getName());
        templateAttributeRange.add("operator", rule.getOperator().toUpperCase());
        templateAttributeRange.add("min", rule.getValueByKey("min"));
        templateAttributeRange.add("max", rule.getValueByKey("max"));
        templateAttributeRange.add("error_code", rule.getError().getErrorCode());
        templateAttributeRange.add("error", rule.getError().getMessage());
        return templateAttributeRange.render();
    }
}
