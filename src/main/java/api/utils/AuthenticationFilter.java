package api.utils;

import org.json.JSONObject;

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
        JSONObject errorMsg = new JSONObject().put("message", "401 - Unauthorized");

        try {
            String apiKey = requestContext.getHeaderString("api-Key");

            if (!apiKey.equals("ceef8bcd-0021-432d-9f82-77284c2a2347")) {
                throw new NotAuthorizedException("Unauthorized");
            }
        } catch (NullPointerException | NotAuthorizedException e) {
            requestContext.abortWith(Response.status(401).entity(errorMsg.toString()).build());
        }
    }
}
