package persistence.generate;

public interface GeneratedRuleDAO {
    void insert(int ruleID, String lang, String sql);
    String getName(int generatedID);
    void updateActiveState(int generatedID, int state);
}
