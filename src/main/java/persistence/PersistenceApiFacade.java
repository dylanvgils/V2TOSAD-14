package persistence;

import persistence.api.AccessLogDAO;
import persistence.api.AccessLogImpl;
import persistence.api.ApiKeyDAO;
import persistence.api.ApiKeyImpl;

public class PersistenceApiFacade {
    private static final ApiKeyDAO apiKey = new ApiKeyImpl();
    private static final AccessLogDAO accessLog = new AccessLogImpl();

    private static int getApikeyID(String key) {
        return apiKey.getApikeyID(key);
    }

    public static boolean authenticated(String key) {
        return apiKey.authenticate(key);
    }

    public static void logAccess(String key, String ip, String agent, String url) {
        accessLog.log(getApikeyID(key), ip, agent, url);
    }
}
