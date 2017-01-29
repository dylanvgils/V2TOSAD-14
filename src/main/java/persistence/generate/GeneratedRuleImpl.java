package persistence.generate;

import persistence.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    @Override
    public String getName(int generatedID) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select name from view_generatedrule where generated_id = ?");
            stmt.setInt(1, generatedID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateActiveState(int generatedID, int state) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("update view_generatedrule set active = ? where generated_id = ?");

            stmt.setInt(1, state);
            stmt.setInt(2, generatedID);

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
