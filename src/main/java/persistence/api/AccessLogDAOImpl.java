package persistence.api;

import persistence.BaseDAO;
import persistence.PersistenceFacade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccessLogDAOImpl extends BaseDAO implements  AccessLogDAO {
    @Override
    public void log(String key, String ip, String agent, String url) {
        int keyID = PersistenceFacade.getApikeyID(key);

        System.out.println(keyID);

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
