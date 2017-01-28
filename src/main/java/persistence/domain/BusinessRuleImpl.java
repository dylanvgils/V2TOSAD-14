package persistence.domain;

import businessLogic.domain.AttributeRule;
import businessLogic.domain.BusinessRule;
import businessLogic.domain.BusinessRuleType;
import businessLogic.domain.TupleRule;
import persistence.BaseDAO;
import persistence.PersistenceDomainFacade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessRuleImpl extends BaseDAO implements BusinessRuleDAO {
    @Override
    public BusinessRule getBusinessRuleByRuleID(int ruleID) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select * from view_businessrule where rule_id = ?");
            stmt.setInt(1, ruleID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                BusinessRuleType ruleType = PersistenceDomainFacade.getBusinessRuleType(rs.getInt("type_id"));
                switch (ruleType.getCode()) {
                    case "ARNG":
                    case "ACMP":
                    case "ALIS":
                    case "AOTH":
                        return new AttributeRule(
                            rs.getInt("rule_id"),
                            rs.getString("name"),
                            rs.getString("operator"),
                            rs.getString("trigger_type"),
                            ruleType,
                            PersistenceDomainFacade.getFailureHandeling(rs.getInt("failure_id"))
                        );
                    case "TCMP":
                        return new TupleRule(
                                rs.getInt("rule_id"),
                                rs.getString("name"),
                                rs.getString("operator"),
                                rs.getString("trigger_type"),
                                ruleType,
                                PersistenceDomainFacade.getFailureHandeling(rs.getInt("failure_id"))
                        );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
