package businessLogic.generate;

import businessLogic.domain.AttributeRule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by Dion on 1/22/2017.
 */
public class AttributeCompareGenerate extends Generate<AttributeRule> {

    public String generateRule(String lang, AttributeRule rule){
        STGroup stGroup = new STGroupFile(getClass().getClassLoader().getResource(lang.toLowerCase() + "/AttributeCompareRule.stg").getFile());

        String triggerType = rule.getTriggerType();
        ST templateAttributeCompare = stGroup.getInstanceOf("templateTrigger"+triggerType);

        templateAttributeCompare.add("ruleID", rule.getRuleID());
        templateAttributeCompare.add("ruleType", rule.getBusinessRuleType().getCode());
        templateAttributeCompare.add("application", "x");
        templateAttributeCompare.add("table", rule.getTables().getName());
        templateAttributeCompare.add("column", rule.getColumns().getName());
        templateAttributeCompare.add("operator", Generate.getOperator(lang, rule.getOperator()));
        templateAttributeCompare.add("max", rule.getValueByKey("max"));
        templateAttributeCompare.add("error_code", rule.getError().getErrorCode());
        templateAttributeCompare.add("error", rule.getError().getMessage());
        return templateAttributeCompare.render();
    }
}
