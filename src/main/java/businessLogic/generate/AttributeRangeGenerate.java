package businessLogic.generate;

import businessLogic.domain.AttributeRule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by Dion on 1/22/2017.
 */
public class AttributeRangeGenerate implements Generate<AttributeRule> {

    public static String AttributeRangeGenerate(AttributeRule rule){
        AttributeRangeGenerate g = new AttributeRangeGenerate();
        return g.generateRule(rule);
    }
    public String generateRule(AttributeRule rule){
        STGroup stGroup = new STGroupFile(getClass().getClassLoader().getResource("text.stg").getFile());
        ST templateExample = stGroup.getInstanceOf("templateRange");
        templateExample.add("table", rule.getTable().getName());
        templateExample.add("name", rule.getName());
        templateExample.add("column",  rule.getColumn().getName());
        templateExample.add("operator", rule.getOperator());
        templateExample.add("min", rule.getAttributes().get(0).getValue());
        templateExample.add("max", rule.getAttributes().get(1).getValue());
        return templateExample.render();
    }
}