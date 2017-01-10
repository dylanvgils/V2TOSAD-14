package businessLogic;

/**
 * Created by Dion on 1/10/2017.
 */
public class BusinessRuleType {
    private String name;
    private String description;
    private Category category;
    private Example example;

    public BusinessRuleType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public void setExample(Example example){
        this.example = example;
    }
}
