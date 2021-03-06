package api.services;

import businessLogic.RuleFacade;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import persistence.PersistenceGenerateFacade;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.List;

@Path("/generator")
@Produces(MediaType.APPLICATION_JSON)
public class GeneratorService {
    @POST
    @Path("/rules")
    public Response generateRules(String json) {
        Status status = Status.OK;

        JSONObject res = new JSONObject();
        List<Integer> rules = new ArrayList<>();
        String lang = null;

        try {
            JSONObject jObject = new JSONObject(json);
            JSONArray jArray = jObject.getJSONArray("rules");
            lang = jObject.getString("lang");

            for (int i = 0; i < jArray.length(); i ++) {
                rules.add(jArray.getInt(i));
            }
        } catch (JSONException e) {
            status = Status.INTERNAL_SERVER_ERROR;
            res.put("message", "Unable to parse the provided JSON. Check your JSON syntax.");
        }

        if (RuleFacade.generateRules(lang, rules)){
            res.put("message", "Rules generated succesfully!");
        } else {
            status = Status.INTERNAL_SERVER_ERROR;
            res.put("message", "Error encountered while generating the business rule(s). Please check your rule specification.");
        }

        return Response.status(status).entity(res.toString()).build();
    }

    @DELETE
    @Path("/rules")
    public Response deactivateRules(String json) {
        Status status = Status.OK;

        JSONObject res = new JSONObject();
        List<Integer> rules = new ArrayList<>();

        try {
            JSONObject jObject = new JSONObject(json);
            JSONArray jArray = jObject.getJSONArray("rules");

            for (int i = 0; i < jArray.length(); i ++) {
                rules.add(jArray.getInt(i));
            }
        } catch (JSONException e) {
            status = Status.INTERNAL_SERVER_ERROR;
            res.put("message", "Unable to parse the provided JSON. Check your JSON syntax.");
        }

        if (PersistenceGenerateFacade.deactivateRules(rules)){
            res.put("message", "Rule(s) deactivated successfully!");
        } else {
            status = Status.INTERNAL_SERVER_ERROR;
            res.put("message", "Error encountered while deactivating the business rule(s). Please check the specified rules.");
        }

        return Response.status(status).entity(res.toString()).build();
    }
}
