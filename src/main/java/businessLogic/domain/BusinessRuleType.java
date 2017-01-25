package businessLogic.domain;

import persistence.PersistenceFacade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class BusinessRuleType {
    private int ruleID;
    private String name;
    private String code;

    public BusinessRuleType(int ruleID, String name, String code) {
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
