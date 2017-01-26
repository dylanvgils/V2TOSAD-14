package businessLogic.generate;

import businessLogic.domain.AttributeRule;
import businessLogic.domain.BusinessRule;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by Dion on 1/13/2017.
 */
public interface Generate<T> {
    String generateRule(String lang, T rule);
}
