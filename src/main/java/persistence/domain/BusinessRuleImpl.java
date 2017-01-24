package persistence.domain;

import businessLogic.domain.BusinessRule;
import persistence.BaseDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusinessRuleImpl extends BaseDAO implements BusinessRuleDAO {
    @Override
    public BusinessRule getBusinessRuleByRuleID(String ruleID) {
        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs =stmt.executeQuery("select * from view_businessrule");

            if (rs.next()) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
