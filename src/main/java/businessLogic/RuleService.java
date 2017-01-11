package businessLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/10/2017.
 */
public class RuleService {

    public RuleService(){
        List<BusinessRule> rules = new ArrayList<BusinessRule>();

        Operator between = new Operator("Between", "between");
        Attribute min = new Attribute("min", 1);
        Attribute max = new Attribute("max", 10);
        between.addColumn(new Column("columnname", "varchar(255)"));
        between.addAttribute(min);
        between.addAttribute(max);


        BusinessRuleType arng_rule = new BusinessRuleType("Attribute Range rule", "De attribuutwaarde moet wel of niet overeenkomen met een waarde uit een reeks.");
        Category cat = new Category("SDCR", "Static data constraint rules");
        arng_rule.setCategory(cat);
        arng_rule.setExample(new Example("Tussen 1 en 10", "Tentamen.cijfer mag de waarde 1 tot en met 10 hebben. Alle postcodes mogen meedoen, behalve 3700 tot en met 4100."));

        BusinessRule rule = new BusinessRule("test_range", arng_rule);
        rule.addOperator(between);

        rules.add(rule);

    }
}
