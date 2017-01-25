package persistence.domain;

import businessLogic.domain.FailureHandling;

public interface FailureHandelingDAO {
    FailureHandling getFailureHandelingByID(int failureID);
}
