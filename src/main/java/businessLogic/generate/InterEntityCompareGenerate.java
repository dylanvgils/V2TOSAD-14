package businessLogic.generate;

import businessLogic.domain.InterEntityRule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by Dion on 1/27/2017.
 */
public class InterEntityCompareGenerate extends Generate<InterEntityRule> {

    public String generateRule(String lang, InterEntityRule rule){
        STGroup stGroup = new STGroupFile(getClass().getClassLoader().getResource(lang.toLowerCase() + "/InterEntityCompareRule.stg").getFile());

        String triggerType = rule.getTriggerType();
        ST templateInterEntityCompare = stGroup.getInstanceOf("templateTrigger"+triggerType);
        templateInterEntityCompare.add("ruleID", rule.getRuleID());
        templateInterEntityCompare.add("ruleType", rule.getBusinessRuleType().getCode());
        templateInterEntityCompare.add("application", rule.getApplication());
        String[] split = rule.getTables().get(0).getName().split("_");
        templateInterEntityCompare.add("short_table", split[1].substring(0, Math.min(split[1].length(), 3)));
        templateInterEntityCompare.add("table", rule.getTables().get(0).getName());
        templateInterEntityCompare.add("tableOther", rule.getTables().get(1).getName());
        templateInterEntityCompare.add("column", rule.getColumns().get(0).getName());
        templateInterEntityCompare.add("columnOther", rule.getColumns().get(1).getName());
        templateInterEntityCompare.add("operator", Generate.getOperator(lang, rule.getOperator()));
        templateInterEntityCompare.add("FK", rule.getValueByKey("FK"));
        templateInterEntityCompare.add("error_code", rule.getError().getErrorCode());
        templateInterEntityCompare.add("error", rule.getError().getMessage());
        return templateInterEntityCompare.render();
    }
}
