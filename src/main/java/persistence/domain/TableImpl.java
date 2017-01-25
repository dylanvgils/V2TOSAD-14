package persistence.domain;

import businessLogic.domain.Table;
import persistence.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableImpl extends BaseDAO implements TableDAO {
    @Override
    public List<Table> getByBusinessRuleID(int ruleID) {
        List<Table> result = new ArrayList<>();

        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select * from view_table where table_id = ?");
            stmt.setInt(1, ruleID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result.add(new Table(
                    rs.getString("name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
