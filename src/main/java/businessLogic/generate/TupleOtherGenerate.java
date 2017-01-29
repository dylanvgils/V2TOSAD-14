package businessLogic.generate;

import businessLogic.domain.TupleRule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by Dion on 1/27/2017.
 */
public class TupleOtherGenerate extends Generate<TupleRule> {

    public String generateRule(String lang, TupleRule rule){
        STGroup stGroup = new STGroupFile(getClass().getClassLoader().getResource(lang.toLowerCase() + "/TupleOtherRule.stg").getFile());

        String triggerType = rule.getTriggerType();
        ST templateOtherCompare = stGroup.getInstanceOf("templateTrigger"+triggerType);


        return templateOtherCompare.render();
    }
}
