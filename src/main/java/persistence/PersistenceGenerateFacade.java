package persistence;


import persistence.generate.GeneratedRuleDAO;
import persistence.generate.GeneratedRuleImpl;
import persistence.generate.GeneratorDAO;
import persistence.generate.GeneratorImpl;

import java.util.List;

public class PersistenceGenerateFacade {
    private static final GeneratorDAO generator = new GeneratorImpl();
    private static final GeneratedRuleDAO generatedRule = new GeneratedRuleImpl();

    public static void executeQuery(int ruleID, String lang, String sql) {
        generator.executeQuery(sql);
        logGeneratedRule(ruleID, lang, sql);
    }

    public static boolean deactivateRules(List<Integer> rules) {

        for (int rule : rules) {
            String name = getTriggerName(rule);

            if (name != null) {
                generator.executeQuery(String.format("drop trigger %s", name));
                updateGeneratedRule(rule, 0);
            } else return false;
        }

        return true;
    }

    public static void logGeneratedRule(int ruleID, String lang,  String sql) {
        generatedRule.insert(ruleID, lang, sql);
    }

    private static void updateGeneratedRule(int generatedID, int state) {
        generatedRule.updateActiveState(generatedID, state);
    }

    private static String getTriggerName(int generatedID) {
        return generatedRule.getName(generatedID);
    }
}
