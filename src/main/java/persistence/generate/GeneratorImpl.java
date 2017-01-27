package persistence.generate;

import persistence.BaseDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GeneratorImpl extends BaseDAO implements GeneratorDAO {
    @Override
    public void executeQuery(String sql) {
        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();

            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
