package businessLogic.generate;

import businessLogic.domain.InterEntityRule;
import businessLogic.domain.ModifyRule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by Dion on 1/27/2017.
 */
public class ModifyCompareGenerate extends Generate<ModifyRule> {

    public String generateRule(String lang, ModifyRule rule){
        STGroup stGroup = new STGroupFile(getClass().getClassLoader().getResource(lang.toLowerCase() + "/ModifyRule.stg").getFile());

        String triggerType = rule.getTriggerType();
        ST templateModify = stGroup.getInstanceOf("templateTrigger"+triggerType);
        templateModify.add("ruleID", rule.getRuleID());
        templateModify.add("ruleType", rule.getBusinessRuleType().getCode());
        templateModify.add("application", "x");
        templateModify.add("table", rule.getTables().get(0).getName());
        templateModify.add("table", rule.getTables().get(1).getName());
        templateModify.add("column", rule.getColumns().get(0).getName());
        templateModify.add("columnOther", rule.getColumns().get(1).getName());
        templateModify.add("operator", Generate.getOperator(lang, rule.getOperator()));
        templateModify.add("FK", rule.getValueByKey("FK"));
        return templateModify.render();
    }
}
