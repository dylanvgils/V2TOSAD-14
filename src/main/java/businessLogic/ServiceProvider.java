package businessLogic;

/**
 * Created by Dion on 1/10/2017.
 */
public class ServiceProvider {
    private static RuleService ruleService = new RuleService();

    public static RuleService getRuleService(){
        return ruleService;
    }
}
