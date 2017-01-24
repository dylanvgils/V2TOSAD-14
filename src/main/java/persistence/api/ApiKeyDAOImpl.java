package persistence.api;

import persistence.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApiKeyDAOImpl extends BaseDAO implements ApiKeyDAO {
    @Override
    public boolean authenticate(String key) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select id from view_apikey where apikey = ?");

            stmt.setString(1, key);

            ResultSet rs = stmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
