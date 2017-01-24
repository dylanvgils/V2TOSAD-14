package persistence.api;

public interface AccessLogDAO {
    void log(int key, String ip, String agent, String url);
}
