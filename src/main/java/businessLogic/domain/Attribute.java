package businessLogic.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class Attribute {
    private int ruleID;
    private String key;
    private String value;
    private static List<Attribute> attibutes = new ArrayList<>();

    public static void initAttributes(){
        attibutes.add(new Attribute(1, "key", "value"));
        attibutes.add(new Attribute(2, "key", "value"));
        attibutes.add(new Attribute(3, "key", "value"));
    }

    public static Attribute createAttribute(int ruleID, String key, String value){
        Attribute attribute = new Attribute(ruleID, key, value);
        addAttribute(attribute);
        return attribute;
    }

    public static List<Attribute> getAttributes(int ruleID){
        List<Attribute> attibuteByID = new ArrayList<>();
        for (Attribute a : attibutes) {
            if(a.getRuleID() == ruleID){
                attibuteByID.add(a);
            }
        }
        return attibuteByID;
    }

    public static void addAttribute(Attribute attribute){
        attibutes.add(attribute);
    }

    public int getRuleID() {
        return ruleID;
    }

    public Attribute(int ruleID, String key, String value) {
        this.ruleID = ruleID;
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
