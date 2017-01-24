package persistence;

import persistence.api.AccessLogDAO;
import persistence.api.AccessLogDAOImpl;
import persistence.api.ApiKeyDAO;
import persistence.api.ApiKeyDAOImpl;
import persistence.databaseMeta.*;

import java.util.List;

public class PersistenceFacade {
    private static final TableMetaDAO tableMeta = new TableMetaDAOImpl();
    private static final ApiKeyDAO apiKey = new ApiKeyDAOImpl();
    private static final AccessLogDAO accessLog = new AccessLogDAOImpl();

    private static int getApikeyID(String key) {
        return apiKey.getApikeyID(key);
    }

    public static boolean authenticated(String key) {
        return apiKey.authenticate(key);
    }

    public static void logAccess(String key, String ip, String agent, String url) {
        accessLog.log(getApikeyID(key), ip, agent, url);
    }

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
