package api.services;


import businessLogic.RuleFacade;
import businessLogic.domain.*;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

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

    @POST
    @Path("/json")
    @Consumes("application/json")
    @Produces("application/json")
    public Response jsonTest(String json) {
        JSONObject jsonObject = new JSONObject(json)
            .put("message", "YOLO");

        return Response.status(200).entity(jsonObject.toString()).build();
    }
}
