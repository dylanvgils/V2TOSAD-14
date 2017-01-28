package businessLogic.domain;

import persistence.PersistenceDomainFacade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class Attribute {
    private String key;
    private String value;
    private static List<Attribute> attributes = new ArrayList<>();

    public static List<Attribute> getAttributes(int ruleID){
        attributes.clear();
        attributes.addAll(PersistenceDomainFacade.getAttributes(ruleID));
        return attributes;
    }

    public static void addAttribute(Attribute attribute){
        attributes.add(attribute);
    }

    public Attribute(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getKey(){
        return key;
    }
}
