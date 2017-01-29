package businessLogic.generate;

import businessLogic.domain.InterEntityRule;
import businessLogic.domain.TupleRule;
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
        templateInterEntityCompare.add("application", "x");
        templateInterEntityCompare.add("table", rule.getTables().get(0).getName());
        templateInterEntityCompare.add("table", rule.getTables().get(1).getName());
        templateInterEntityCompare.add("column", rule.getColumns().get(0).getName());
        templateInterEntityCompare.add("columnOther", rule.getColumns().get(1).getName());
        templateInterEntityCompare.add("operator", Generate.getOperator(lang, rule.getOperator()));
        templateInterEntityCompare.add("FK", rule.getValueByKey("FK"));
        return templateInterEntityCompare.render();
    }
}
