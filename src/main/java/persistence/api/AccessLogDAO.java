package persistence.api;

public interface AccessLogDAO {
    void log(String key, String ip, String agent, String url);
}
