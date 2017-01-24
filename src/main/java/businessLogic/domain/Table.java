package businessLogic.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class Table {
    private int ruleID;
    private String name;
    private static List<Table> tables = new ArrayList<Table>();

    public static void initTables(){
        tables.add(new Table(1, "name"));
        tables.add(new Table(2, "name"));
        tables.add(new Table(3, "name"));
    }

    public static Table createTable(int ruleID, String name){
        Table table = new Table(ruleID, name);
        addTable(table);
        return table;
    }

    public static List<Table> getTables(int ruleID){
        List<Table> tableByID = new ArrayList<>();
        for (Table t : tables) {
            if(t.getRuleID() == ruleID){
                tableByID.add(t);
            }
        }
        return tableByID;
    }

    public static void addTable(Table table){
        tables.add(table);
    }

    public Table(int ruleID, String name) {
        this.ruleID = ruleID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRuleID() {
        return ruleID;
    }
}
