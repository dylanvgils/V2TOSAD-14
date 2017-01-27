package persistence.generate;

import persistence.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GeneratedRuleImpl extends BaseDAO implements GeneratedRuleDAO {
    @Override
    public void insert(int ruleID, String lang, String sql) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("insert into view_generatedrule (rule_id, lang, code, active) values (?, ?, ?, ?)");

            stmt.setInt(1, ruleID);
            stmt.setString(2, lang);
            stmt.setString(3, sql);
            stmt.setInt(4, 1);

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
