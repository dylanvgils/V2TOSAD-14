package persistence;

import java.util.List;

public class PersistenceFacade {
    private static final TableMetaDAO tableMeta = new TableMetaDAOImpl();

    public static List<TableMetaDTO> getTables() {
        return tableMeta.getTables();
    }

    public static List<ColumnMetaDTO> getColumens(String name) {
        return tableMeta.getColumns(name);
    }
}
