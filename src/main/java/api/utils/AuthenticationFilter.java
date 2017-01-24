package api.utils;

import org.json.JSONObject;
import persistence.PersistenceFacade;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        try {
            String key = requestContext.getHeaderString("api-key");

            if (!PersistenceFacade.authenticated(key)) {
                throw new NotAuthorizedException("Unauthorized");
            }
        } catch (NullPointerException | NotAuthorizedException e) {
            JSONObject errorMsg = new JSONObject().put("message", "401 - Unauthorized");
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(errorMsg.toString()).build());
        }
    }
}
