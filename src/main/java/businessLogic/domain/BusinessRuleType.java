package businessLogic.domain;

/**
 * Created by Dion on 1/13/2017.
 */
public class BusinessRuleType {
    private String name;
    private String code;

    public BusinessRuleType(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
