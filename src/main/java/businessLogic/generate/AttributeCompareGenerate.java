package businessLogic.generate;

import businessLogic.domain.AttributeRule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by Dion on 1/22/2017.
 */
public class AttributeCompareGenerate implements Generate<AttributeRule> {

    public static String AttributeCompareGenerate(String lang, AttributeRule rule){
        AttributeCompareGenerate g = new AttributeCompareGenerate();
        return g.generateRule(lang, rule);
    }
    public String generateRule(String lang, AttributeRule rule){
        STGroup stGroup = new STGroupFile(getClass().getClassLoader().getResource(lang+"/AttributeRangeRule.stg").getFile());

        String triggerType = "BeforeRow";
        ST templateExample = stGroup.getInstanceOf("templateTrigger"+triggerType);
        templateExample.add("table", rule.getTables().getName());
        templateExample.add("when", "insert");
        templateExample.add("name", "koekje");
        templateExample.add("column", rule.getColumns().getName());
        templateExample.add("operator", rule.getOperator());
        templateExample.add("max", rule.getValueByKey("max"));
        templateExample.add("error_code", rule.getError().getErrorCode());
        templateExample.add("error", rule.getError().getMessage());
        return templateExample.render();
    }
}