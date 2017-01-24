package persistence.api;

public interface ApiKeyDAO {
    int getApikeyID(String key);
    boolean authenticate(String key);
}
