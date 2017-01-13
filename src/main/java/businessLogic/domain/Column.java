package businessLogic.domain;

/**
 * Created by Dion on 1/13/2017.
 */
public class Column {
    private String name;
    private String type;

    public Column(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
}
