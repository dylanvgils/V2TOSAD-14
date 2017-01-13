package businessLogic.domain;

/**
 * Created by Dion on 1/13/2017.
 */
public class Attribute {
    private String key;
    private String value;

    public Attribute(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
