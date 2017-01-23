package persistence;

import java.util.List;

public interface TableMetaDAO {
    List<TableMetaDTO> getTables();
    List<ColumnMetaDTO> getColumns(String name);
}
