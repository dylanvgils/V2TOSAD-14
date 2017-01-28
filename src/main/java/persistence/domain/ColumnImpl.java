package persistence.domain;

import businessLogic.domain.Column;
import persistence.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColumnImpl extends BaseDAO implements ColumnDAO {
    @Override
    public List<Column> getByBusinessRuleID(int ruleID) {
        List<Column> result = new ArrayList<>();

        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select * from view_column where rule_id = ?");
            stmt.setInt(1, ruleID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result.add(new Column(
                    rs.getString("name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
