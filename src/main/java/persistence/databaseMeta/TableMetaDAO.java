package persistence.databaseMeta;

import java.util.List;

public interface TableMetaDAO {
    List<DatabaseSchemaDTO> getSchemas();
    List<TableMetaDTO> getTables();
    List<ColumnMetaDTO> getColumns(String tableName);
    ColumnMetaDTO getColumn(String talbeName, String columnName);
}
