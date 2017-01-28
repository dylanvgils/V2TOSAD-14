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
        STGroup stGroup = new STGroupFile(getClass().getClassLoader().getResource(lang.toLowerCase() + "/TupleCompareRule.stg").getFile());

        String triggerType = rule.getTriggerType();
        ST templateTupleCompare = stGroup.getInstanceOf("templateTrigger"+triggerType);

        return templateTupleCompare.render();
    }
}
