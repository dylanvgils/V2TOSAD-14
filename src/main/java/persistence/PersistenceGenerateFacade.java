package persistence;


import persistence.generate.GeneratedRuleDAO;
import persistence.generate.GeneratedRuleImpl;
import persistence.generate.GeneratorDAO;
import persistence.generate.GeneratorImpl;

public class PersistenceGenerateFacade {
    private static final GeneratorDAO generator = new GeneratorImpl();
    private static final GeneratedRuleDAO generatedRule = new GeneratedRuleImpl();

    public static void executeQuery(int ruleID, String lang, String sql) {
        generator.executeQuery(sql);
        logGeneratedRule(ruleID, lang, sql);
    }

    public static void logGeneratedRule(int ruleID, String lang,  String sql) {
        generatedRule.insert(ruleID, lang, sql);
    }
}
