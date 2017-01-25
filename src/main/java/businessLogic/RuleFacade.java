package businessLogic;

import businessLogic.domain.*;
import businessLogic.generate.Generate;
import businessLogic.generate.GenerateFactory;

import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class RuleFacade {

    public static void generateRules(List<Integer> rules){
        for (Integer r: rules) {
            generateRule(r);
        }
    }

    public static String generateRule(int ruleID){
        BusinessRule rule;
        GenerateFactory factory = new GenerateFactory();


        try {
            rule = BusinessRule.getRule(ruleID);
            rule.setAttributes(Attribute.getAttributes(ruleID));
            rule.setColumns(Column.getColumns(ruleID));
            rule.setTables(Table.getTables(ruleID));
        } catch (NullPointerException e) {
            return null;
        }

        Generate generator = factory.getGenerate(rule.getType().getCode());

        return generator.generateRule(rule);

    }
}
