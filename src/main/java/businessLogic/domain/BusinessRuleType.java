package businessLogic.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class BusinessRuleType {
    private int ruleID;
    private String name;
    private String code;

    private static List<BusinessRuleType> ruleTypes = new ArrayList<>();

    public static void initRuleTypes(){
        ruleTypes.add(new BusinessRuleType(1, "naam", "ARNG"));
        ruleTypes.add(new BusinessRuleType(2, "naam", "code"));
        ruleTypes.add(new BusinessRuleType(3, "naam", "code"));
    }

    public static BusinessRuleType createBusinessRuleType(int ruleID, String name, String code){
        BusinessRuleType businessRuleType = new BusinessRuleType(ruleID, name, code);
        addBusinessRuleType(businessRuleType);
        return businessRuleType;
    }

    public static BusinessRuleType getBusinessRuleType(int ruleID){
        for (BusinessRuleType r : ruleTypes) {
            if(r.getRuleID() == ruleID){
                return r;
            }
        }
        return null;
    }

    public static void addBusinessRuleType(BusinessRuleType failureHandling){
        ruleTypes.add(failureHandling);
    }

    public BusinessRuleType(int ruleID, String name, String code) {
        this.ruleID = ruleID;
        this.name = name;
        this.code = code;
    }

    public BusinessRuleType(String name, String code) {
        this.ruleID = ruleID;
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getRuleID() {
        return ruleID;
    }
}
