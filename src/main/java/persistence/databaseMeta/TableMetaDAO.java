package persistence.databaseMeta;

import persistence.databaseMeta.ColumnMetaDTO;
import persistence.databaseMeta.DatabaseSchemaDTO;
import persistence.databaseMeta.TableMetaDTO;

import java.util.List;

public interface TableMetaDAO {
    List<DatabaseSchemaDTO> getSchemas();
    List<TableMetaDTO> getTables();
    List<ColumnMetaDTO> getColumns(String tableName);
    ColumnMetaDTO getColumn(String talbeName, String columnName);
}
