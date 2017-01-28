package businessLogic.domain;

import persistence.PersistenceDomainFacade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class Column {
    private String name;
    private static List<Column> columns = new ArrayList<>();

    public static List<Column> getColumns(int ruleID){
        columns.removeAll(columns);
        columns.addAll(PersistenceDomainFacade.getColumns(ruleID));
        return columns;
    }

    public Column(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
