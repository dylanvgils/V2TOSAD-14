package persistence.api;

public interface ApiKeyDAO {
    boolean authenticate(String key);
}
