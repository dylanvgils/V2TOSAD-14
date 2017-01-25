package persistence.domain;

import businessLogic.domain.BusinessRuleType;
import persistence.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessRuleTypeImpl extends BaseDAO implements BusinessRuleTypeDAO {
    @Override
    public BusinessRuleType getBusinessRuleTypeByID(int typeID) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("select * from view_businessruletype where type_id = ?");
            stmt.setInt(1, typeID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new BusinessRuleType(
                    rs.getString("name"),
                    rs.getString("code")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
