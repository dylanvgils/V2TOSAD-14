package persistence.api;

import persistence.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccessLogImpl extends BaseDAO implements AccessLogDAO {
    @Override
    public void log(int keyID, String ip, String agent, String url) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("insert into view_accesslog (apikey_id, user_ip, user_agent, url) values (?, ?, ?, ?)");
            stmt.setInt(1, keyID);
            stmt.setString(2, ip);
            stmt.setString(3, agent);
            stmt.setString(4, url);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
