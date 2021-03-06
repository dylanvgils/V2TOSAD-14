package businessLogic;

import businessLogic.domain.Attribute;
import businessLogic.domain.BusinessRule;
import businessLogic.domain.Column;
import businessLogic.domain.Table;
import businessLogic.generate.Generate;
import businessLogic.generate.GenerateFactory;
import persistence.PersistenceGenerateFacade;

import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class RuleFacade {

    public static boolean generateRules(String lang, List<Integer> rules){
        boolean result = true;

        for (Integer r: rules) {
            result = result && generateRule(lang, r);
        }

        return result;
    }

    public static boolean generateRule(String lang, int ruleID){
        BusinessRule rule;
        GenerateFactory factory = new GenerateFactory();

        try {
            rule = BusinessRule.getRule(ruleID);

            if (rule.getType().getCode().startsWith("A") || rule.getType().getCode().startsWith("E") || rule.getType().getCode().startsWith("I")) {
                rule.setAttributes(Attribute.getAttributes(ruleID));
            }

            rule.setColumns(Column.getColumns(ruleID));
            rule.setTables(Table.getTables(ruleID));
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }

        Generate generator = factory.getGenerate(rule.getType().getCode());
        PersistenceGenerateFacade.executeQuery(ruleID, lang, generator.generateRule(lang, rule));
        return true;
    }
}
