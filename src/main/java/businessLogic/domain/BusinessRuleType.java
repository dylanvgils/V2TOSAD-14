package businessLogic.domain;

/**
 * Created by Dion on 1/13/2017.
 */
public class BusinessRuleType {
    private String name;
    private String description;
    private String code;

    public BusinessRuleType(String name, String description, String code) {
        this.name = name;
        this.description = description;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }
}
