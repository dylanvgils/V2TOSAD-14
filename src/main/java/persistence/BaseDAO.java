package persistence;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO {
    protected final Connection getConnection() {
        Connection conn;

        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/OracleSQL");
            conn = ds.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return conn;
    }
}
