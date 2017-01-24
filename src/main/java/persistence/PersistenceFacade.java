package persistence;

import persistence.databaseMeta.*;

import java.util.List;

public class PersistenceFacade {
    private static final TableMetaDAO tableMeta = new TableMetaDAOImpl();

    public static List<DatabaseSchemaDTO> getSchemas() {
        return tableMeta.getSchemas();
    }

    public static List<TableMetaDTO> getTables(String schemaName) {
        return tableMeta.getTables();
    }

    public static List<ColumnMetaDTO> getColumens(String schemaName, String tableName) {
        return tableMeta.getColumns(tableName);
    }

    public static ColumnMetaDTO getColumn(String schemaName, String tableName, String columnName) {
        return tableMeta.getColumn(tableName, columnName);
    }
}
