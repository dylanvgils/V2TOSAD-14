package businessLogic.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class FailureHandling {
    private int ruleID;
    private String type;
    private String message;
    private int errorCode;
    private static List<FailureHandling> failureHandlings = new ArrayList<>();

    public static void initFailureHandling(){
        failureHandlings.add(new FailureHandling(1, "type", "message", 299));
        failureHandlings.add(new FailureHandling(2, "type", "message", 299));
        failureHandlings.add(new FailureHandling(3, "type", "message", 299));
    }

    public static FailureHandling createFailurehandling(int ruleID, String type, String message, int errorCode){
        FailureHandling failureHandling = new FailureHandling(ruleID, type, message, errorCode);
        addFailureHandling(failureHandling);
        return failureHandling;
    }

    public static FailureHandling getFailureHandling(int ruleID){
        for (FailureHandling f : failureHandlings) {
            if(f.getRuleID() == ruleID){
               return f;
            }
        }
        return null;
    }

    public static void addFailureHandling(FailureHandling failureHandling){
        failureHandlings.add(failureHandling);
    }

    public FailureHandling(int ruleID, String type, String message, int errorCode) {
        this.ruleID = ruleID;
        this.type = type;
        this.message = message;
        this.errorCode = errorCode;
    }

    public int getRuleID() {
        return ruleID;
    }
}
