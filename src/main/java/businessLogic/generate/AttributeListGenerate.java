package businessLogic.generate;

import businessLogic.domain.AttributeRule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by Dion on 1/22/2017.
 */
public class AttributeListGenerate extends Generate<AttributeRule> {

    public String generateRule(String lang, AttributeRule rule){
        STGroup stGroup = new STGroupFile(getClass().getClassLoader().getResource(lang.toLowerCase() + "/AttributeListRule.stg").getFile());

        String triggerType = rule.getTriggerType();
        ST templateAttributeList = stGroup.getInstanceOf("templateTrigger"+triggerType);
        templateAttributeList.add("ruleID", rule.getRuleID());
        templateAttributeList.add("ruleType", rule.getBusinessRuleType().getCode());
        templateAttributeList.add("application", rule.getApplication());
        templateAttributeList.add("table", rule.getTables().getName());
        templateAttributeList.add("column", rule.getColumns().getName());
        templateAttributeList.add("operator", rule.getOperator().toUpperCase());
        String attributes = "'"+rule.getValueByKey("max").replace(":", "','")+"'";
        templateAttributeList.add("attributes", attributes);
        templateAttributeList.add("error_code", rule.getError().getErrorCode());
        templateAttributeList.add("error", rule.getError().getMessage());

        return templateAttributeList.render();
    }
}
