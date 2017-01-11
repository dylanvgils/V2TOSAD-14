package businessLogic;

import java.util.List;

/**
 * Created by Dion on 1/10/2017.
 */
public class Operator {
    private String name;
    private String codeTranslation;
    private List<BusinessRule> businessRules;
    private List<Column> columns;
    private List<Attribute> attributes;

    public Operator(String name, String codeTranslation) {
        this.name = name;
        this.codeTranslation = codeTranslation;
    }

    public void addColumn(Column column) {
        this.columns.add(column);
    }

    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
    }
}
