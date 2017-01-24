package businessLogic.domain;

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

    public static void initColumns(){
        columns.add(new Column(1, "test", "type"));
        columns.add(new Column(2, "test", "type"));
        columns.add(new Column(3, "test", "type"));
    }

    public static Column createColumn(int ruleID, String name, String type){
        Column column = new Column(ruleID, name, type);
        addColumn(column);
        return column;
    }

    public static List<Column> getColumns(int ruleID){
        List<Column> columnByID = new ArrayList<>();
        for (Column c : columns) {
            if(c.getRuleID() == ruleID){
                columnByID.add(c);
            }
        }
        return columnByID;
    }

    public static void addColumn(Column column){
        columns.add(column);
    }

    public Column(int ruleID, String name, String type) {
        this.ruleID = ruleID;
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
