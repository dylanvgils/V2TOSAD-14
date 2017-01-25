package persistence.domain;

import businessLogic.domain.AttributeRule;
import businessLogic.domain.BusinessRule;
import businessLogic.domain.BusinessRuleType;
import persistence.BaseDAO;
import persistence.PersistenceFacade;

import java.sql.*;

public class BusinessRuleImpl extends BaseDAO implements BusinessRuleDAO {
    @Override
    public BusinessRule getBusinessRuleByRuleID(int ruleID) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select * from view_businessrule where rule_id = ?");
            stmt.setInt(1, ruleID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                BusinessRuleType ruleType = PersistenceFacade.getBusinessRuleType(rs.getInt("rule_id"));

                switch (ruleType.getCode()) {
                    case "ARNG":
                    case "ACMP":
                    case "ALIS":
                    case "AOTH":
                        return new AttributeRule(
                            rs.getInt("rule_id"),
                            rs.getString("name"),
                            rs.getString("operator"),
                            ruleType,
                            PersistenceFacade.getFailureHandeling(rs.getInt("failure_id"))
                        );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
