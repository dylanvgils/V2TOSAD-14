package businessLogic.domain;

import persistence.PersistenceDomainFacade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/13/2017.
 */
public class Table {
    private String name;
    private static List<Table> tables = new ArrayList<>();

    public static List<Table> getTables(int ruleID){
        tables.clear();
        tables.addAll(PersistenceDomainFacade.getTables(ruleID));
        return tables;
    }

    public static void addTable(Table table){
        tables.add(table);
    }

    public Table(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
