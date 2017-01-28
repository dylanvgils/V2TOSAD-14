package businessLogic.generate;

import businessLogic.domain.AttributeRule;
import businessLogic.domain.BusinessRule;
import org.json.JSONArray;
import org.json.JSONObject;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.InputStream;

/**
 * Created by Dion on 1/13/2017.
 */
public abstract class Generate<T> {
    static String getOperator(String lang, String operator){
        InputStream inputStream = Generate.class.getClassLoader().getResourceAsStream(lang+"/operator.json");
        JSONObject jObject = new JSONObject(inputStream);
        return jObject.getString(operator.toLowerCase());
    }

    public abstract String generateRule(String lang, T rule);

}
