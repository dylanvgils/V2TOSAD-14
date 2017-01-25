package persistence.domain;

import businessLogic.domain.FailureHandling;
import persistence.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FailureHandelingImpl extends BaseDAO implements FailureHandelingDAO {
    @Override
    public FailureHandling getFailureHandelingByID(int failureID) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select * from view_failurehandeling where failure_id = ?");
            stmt.setInt(1, failureID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new FailureHandling(
                    rs.getString("type"),
                    rs.getString("message"),
                    rs.getInt("errorcode")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
