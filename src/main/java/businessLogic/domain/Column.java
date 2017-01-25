package businessLogic.domain;

import persistence.PersistenceFacade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class Column {
    private int ruleID;
    private String name;
    private String type;
    private static List<Column> columns = new ArrayList<>();

    public static List<Column> getColumns(int ruleID){
        columns.addAll(PersistenceFacade.getColumns(ruleID));
        return columns;
    }

    public Column(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public int getRuleID() {
        return ruleID;
    }



    public String getName() {
        return name;
    }
}
