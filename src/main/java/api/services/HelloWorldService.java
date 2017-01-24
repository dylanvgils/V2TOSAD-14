package api.services;


import businessLogic.RuleFacade;
import businessLogic.domain.*;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldService {
    @GET
    @Produces("text/plain")
    public Response sayHello() {
        Table.initTables();
        AttributeRule.initAttributeRule();
        Attribute.initAttributes();
        BusinessRuleType.initRuleTypes();
        FailureHandling.initFailureHandling();
        Column.initColumns();
        return Response.status(200).entity(RuleFacade.generateRule(1)).build();
    }

    @GET
    @Path("{name}")
    @Produces("application/json")
    public Response sayHello(@PathParam("name") String name) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("status", new JSONObject()
            .put("code", 200)
            .put("message", String.format("Hello, %s!", name))
        );

        return Response.status(200).entity(jsonObject.toString()).build();
    }
}
