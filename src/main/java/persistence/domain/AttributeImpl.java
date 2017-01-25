package persistence.domain;

import businessLogic.domain.Attribute;
import persistence.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttributeImpl extends BaseDAO implements AttributeDAO {
    @Override
    public List<Attribute> getByBusinessRuleID(int ruleID) {
        List<Attribute> result = new ArrayList<>();

        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select * from view_attribute where rule_id = ?");
            stmt.setInt(1, ruleID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result.add(new Attribute(
                    rs.getString("key"),
                    rs.getString("value")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
