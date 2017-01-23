package services;


import businessLogic.RuleFacade;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.ColumnMetaDTO;
import persistence.PersistenceFacade;
import persistence.TableMetaDTO;

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
        RuleFacade.createAttributeRule();
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

    @GET
    @Path("/db")
    @Produces("application/json")
    public Response getTables() {
        JSONObject jsonObject = new JSONObject();

        JSONArray tableArray = new JSONArray();
        for (TableMetaDTO tm : PersistenceFacade.getTables()) {
            tableArray.put(tm.getName());
        }

        jsonObject.put("tables", tableArray);

        return Response.status(200).entity(jsonObject.toString()).build();
    }

    @GET
    @Path("/db/{name}")
    @Produces("application/json")
    public Response getColumns(@PathParam("name") String name) {
        JSONObject jsonObject = new JSONObject();

        JSONArray columnArray = new JSONArray();
        for (ColumnMetaDTO cm : PersistenceFacade.getColumens(name)) {
            columnArray.put(new JSONObject()
                .put("column_name", cm.getName())
                .put("data_type", cm.getDataType())
                .put("data_length", cm.getDataLength())
                .put("data_precision", cm.getDataPrecision())
                .put("data_scale", cm.getDataScale())
            );
        }

        jsonObject.put(name, columnArray);

        return Response.status(200).entity(jsonObject.toString()).build();
    }
}
