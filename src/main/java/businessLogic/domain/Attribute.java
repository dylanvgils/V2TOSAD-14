package businessLogic.domain;

import persistence.PersistenceFacade;

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

    public static List<Attribute> getAttributes(int ruleID){
        attibutes.addAll(PersistenceFacade.getAttributes(ruleID));
        return attibutes;
    }

    public static void addAttribute(Attribute attribute){
        attibutes.add(attribute);
    }

    public int getRuleID() {
        return ruleID;
    }

    public Attribute(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
