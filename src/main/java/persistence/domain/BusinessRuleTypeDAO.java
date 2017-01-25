package persistence.domain;

import businessLogic.domain.BusinessRuleType;

public interface BusinessRuleTypeDAO {
    BusinessRuleType getBusinessRuleTypeByID(int typeID);
}
