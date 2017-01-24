package persistence.databaseMeta;

import persistence.BaseDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableMetaDAOImpl extends BaseDAO implements TableMetaDAO {

    public List<DatabaseSchemaDTO> getSchemas() {
        List<DatabaseSchemaDTO> result = new ArrayList<>();

        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from view_database_schema");

            while (rs.next()) {
                result.add(new DatabaseSchemaDTO(
                   rs.getString("schema_name")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<TableMetaDTO> getTables() {
        List<TableMetaDTO> result = new ArrayList<>();

        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from view_table_meta");

            while (rs.next()) {
                result.add(new TableMetaDTO(
                    rs.getString("table_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private List<ColumnMetaDTO> getColumnMeta(PreparedStatement stmt) throws SQLException {
        List<ColumnMetaDTO> result = new ArrayList<>();

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            result.add(new ColumnMetaDTO(
                    rs.getString("column_name"),
                    rs.getString("data_type"),
                    rs.getInt("data_length"),
                    rs.getInt("data_precision"),
                    rs.getInt("data_scale")
            ));
        }

        return result;
    }

    public List<ColumnMetaDTO> getColumns(String tableName) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select * from view_column_meta where table_name = upper(?)");

            stmt.setString(1, tableName);

            return getColumnMeta(stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ColumnMetaDTO getColumn(String tableName, String columnName) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select * from view_column_meta where table_name = upper(?) and column_name = upper(?)");

            stmt.setString(1, tableName);
            stmt.setString(2, columnName);

            List<ColumnMetaDTO> result = getColumnMeta(stmt);
            return !result.isEmpty() ? result.get(0) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
