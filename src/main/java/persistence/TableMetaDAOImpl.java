package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableMetaDAOImpl extends BaseDAO implements TableMetaDAO {

    public List<TableMetaDTO> getTables() {
        List<TableMetaDTO> result = new ArrayList<>();

        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT table_name FROM user_tables WHERE table_name NOT LIKE 'BRG%'");

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

    public List<ColumnMetaDTO> getColumns(String tableName) {
        List<ColumnMetaDTO> result = new ArrayList<>();

        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT column_name, data_type, data_length, data_precision, data_scale FROM user_tab_columns WHERE table_name = UPPER(?)");
            stmt.setString(1, tableName);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
