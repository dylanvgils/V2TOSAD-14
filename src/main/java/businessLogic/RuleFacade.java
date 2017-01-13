package businessLogic;

import businessLogic.domain.*;
import businessLogic.generate.Generator;

/**
 * Created by Dion on 1/13/2017.
 */
public class RuleFacade {
    public static void createAttributeRule(){
        AttributeRule testRule = AttributeRule.createRule(1, "testRule", "between", new BusinessRuleType("Attribute range", "kaas", "ARNG"), new FailureHandling("error", "foutje", 300));
        testRule.setColumn(new Column("leeftijd", "date"));
        testRule.setTable(new Table("Tabel"));
        testRule.addAttribute(new Attribute("min", "0"));
        testRule.addAttribute(new Attribute("max", "10"));
    }

    public static String generateRule(int ruleID){
        return Generator.generate((AttributeRule) BusinessRule.getRule(ruleID));
    }
}
