package businessLogic.generate;

import businessLogic.domain.InterEntityRule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by Dion on 1/27/2017.
 */
public class EntityOtherGenerate extends Generate<InterEntityRule> {

    public String generateRule(String lang, InterEntityRule rule){
        STGroup stGroup = new STGroupFile(getClass().getClassLoader().getResource(lang.toLowerCase() + "/EntityOtherRule.stg").getFile());

        String triggerType = rule.getTriggerType();
        ST templateEntityOther = stGroup.getInstanceOf("templateTrigger"+triggerType);

        return templateEntityOther.render();
    }
}
