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

    public FailureHandling(String type, String message, int errorCode) {
        this.type = type;
        this.message = message;
        this.errorCode = errorCode;
    }

    public int getRuleID() {
        return ruleID;
    }
}
