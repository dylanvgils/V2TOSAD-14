package businessLogic.generate;

import businessLogic.domain.AttributeRule;
import businessLogic.domain.TupleRule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by Dion on 1/27/2017.
 */
public class TupleCompareGenerate implements Generate<TupleRule> {

    public String generateRule(String lang, TupleRule rule){
        STGroup stGroup = new STGroupFile(getClass().getClassLoader().getResource(lang.toLowerCase() + "/TupleCompareRule.stg").getFile());

        String triggerType = rule.getTriggerType();
        ST templateTupleCompare = stGroup.getInstanceOf("templateTrigger"+triggerType);
        templateTupleCompare.add("application", "application");
        templateTupleCompare.add("table", rule.getTables());
        templateTupleCompare.add("column", rule.getColumns().get(0));
        templateTupleCompare.add("columnOther", rule.getColumns().get(1));
        templateTupleCompare.add("operator", rule.getOperator());
        templateTupleCompare.add("error_code", rule.getError().getErrorCode());
        templateTupleCompare.add("error", rule.getError().getMessage());

        return templateTupleCompare.render();
    }
}
