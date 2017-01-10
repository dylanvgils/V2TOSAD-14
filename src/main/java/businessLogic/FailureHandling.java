package businessLogic;

/**
 * Created by Dion on 1/10/2017.
 */
public class FailureHandling {
    private String type;
    private String message;
    private String errorCode;

    public FailureHandling(String type, String message, String errorCode) {
        this.type = type;
        this.message = message;
        this.errorCode = errorCode;
    }
}
