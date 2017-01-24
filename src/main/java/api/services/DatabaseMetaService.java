package api.services;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.databaseMeta.ColumnMetaDTO;
import persistence.databaseMeta.DatabaseSchemaDTO;
import persistence.PersistenceFacade;
import persistence.databaseMeta.TableMetaDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

@Path("/meta")
@Produces(MediaType.APPLICATION_JSON)
public class DatabaseMetaService {
    @GET
    @Path("/schemas")
    public Response getSchemas() {
        JSONObject jsonObject = new JSONObject();

        JSONArray jsonArray = new JSONArray();
        for (DatabaseSchemaDTO ds : PersistenceFacade.getSchemas()) {
            jsonArray.put(new JSONObject()
                .put("schema_name", ds.getName())
            );
        }

        jsonObject.put("schemas", jsonArray);

        return Response.status(Status.OK).entity(jsonObject.toString()).build();
    }

    @GET
    @Path("/schemas/{schemaName}")
    public Response getTables(@PathParam("schemaName") String schemaName) {
        JSONObject jsonObject = new JSONObject();

        JSONArray tableArray = new JSONArray();
        for (TableMetaDTO tm : PersistenceFacade.getTables(schemaName)) {
            tableArray.put(tm.getName());
        }

        jsonObject.put("tables", tableArray);

        return Response.status(Status.OK).entity(jsonObject.toString()).build();
    }

    @GET
    @Path("/schemas/{schemaName}/{tableName}")
    public Response getColumns(@PathParam("schemaName") String schemaName, @PathParam("tableName") String tableName) {
        Status status = Status.OK;
        JSONObject jsonObject = new JSONObject();
        JSONArray columnArray = new JSONArray();

        List<ColumnMetaDTO> columns = PersistenceFacade.getColumens(schemaName, tableName);
        if (!columns.isEmpty()) {
            for (ColumnMetaDTO cm : columns) {
                columnArray.put(new JSONObject()
                    .put("column_name", cm.getName())
                    .put("data_type", cm.getDataType())
                    .put("data_length", cm.getDataLength())
                    .put("data_precision", cm.getDataPrecision())
                    .put("data_scale", cm.getDataScale())
                );
            }

            jsonObject.put(tableName, columnArray);
        } else {
            status = Status.NOT_FOUND;
            jsonObject.put("message", String.format("Table with name `%s` does not exists schema `%s`.", tableName, schemaName));
        }

        return Response.status(status).entity(jsonObject.toString()).build();
    }

    @GET
    @Path("/schemas/{schemaName}/{tableName}/{columnName}")
    public Response getColumn(@PathParam("schemaName") String schemaName, @PathParam("tableName") String tableName, @PathParam("columnName") String columnName) {
        Status status = Status.OK;
        JSONObject jsonObject = new JSONObject();

        ColumnMetaDTO cm = PersistenceFacade.getColumn(schemaName, tableName, columnName);
        if (cm != null) {
            jsonObject.put(columnName, new JSONObject()
                .put("data_type", cm.getDataType())
                .put("data_length", cm.getDataLength())
                .put("data_precision", cm.getDataPrecision())
                .put("data_scale", cm.getDataScale())
            );
        } else {
            status = Status.NOT_FOUND;
            jsonObject.put("message", String.format("Column with name `%s` does not exist in table `%s`.", columnName, tableName));
        }


        return Response.status(status).entity(jsonObject.toString()).build();
    }
}
