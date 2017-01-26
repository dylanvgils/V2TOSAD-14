package api.services;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.PersistenceApiFacade;
import persistence.PersistenceDatabaseMetaFacade;
import persistence.databaseMeta.ColumnMetaDTO;
import persistence.databaseMeta.DatabaseSchemaDTO;
import persistence.PersistenceDomainFacade;
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
        JSONObject jObject = new JSONObject();

        JSONArray jsonArray = new JSONArray();
        for (DatabaseSchemaDTO ds : PersistenceDatabaseMetaFacade.getSchemas()) {
            jsonArray.put(ds.getName());
        }

        jObject.put("schemas", jsonArray);

        return Response.status(Status.OK).entity(jObject.toString()).build();
    }

    @GET
    @Path("/schemas/{schemaName}")
    public Response getTables(@PathParam("schemaName") String schemaName) {
        JSONObject jObject = new JSONObject();

        JSONArray tableArray = new JSONArray();
        for (TableMetaDTO tm : PersistenceDatabaseMetaFacade.getTables(schemaName)) {
            tableArray.put(tm.getName());
        }

        jObject.put("tables", tableArray);

        return Response.status(Status.OK).entity(jObject.toString()).build();
    }

    @GET
    @Path("/schemas/{schemaName}/{tableName}")
    public Response getColumns(@PathParam("schemaName") String schemaName, @PathParam("tableName") String tableName) {
        Status status = Status.OK;
        JSONObject jObject = new JSONObject();
        JSONArray columnArray = new JSONArray();

        List<ColumnMetaDTO> columns = PersistenceDatabaseMetaFacade.getColumns(schemaName, tableName);
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

            jObject.put("table", columnArray);
        } else {
            status = Status.NOT_FOUND;
            jObject.put("message", String.format("Table with name `%s` does not exists schema `%s`.", tableName, schemaName));
        }

        return Response.status(status).entity(jObject.toString()).build();
    }

    @GET
    @Path("/schemas/{schemaName}/{tableName}/{columnName}")
    public Response getColumn(@PathParam("schemaName") String schemaName, @PathParam("tableName") String tableName, @PathParam("columnName") String columnName) {
        Status status = Status.OK;
        JSONObject jObject = new JSONObject();

        ColumnMetaDTO cm = PersistenceDatabaseMetaFacade.getColumn(schemaName, tableName, columnName);
        if (cm != null) {
            jObject.put("column", new JSONObject()
                .put("column_name", cm.getName())
                .put("data_type", cm.getDataType())
                .put("data_length", cm.getDataLength())
                .put("data_precision", cm.getDataPrecision())
                .put("data_scale", cm.getDataScale())
            );
        } else {
            status = Status.NOT_FOUND;
            jObject.put("message", String.format("Column with name `%s` does not exist in table `%s`.", columnName, tableName));
        }


        return Response.status(status).entity(jObject.toString()).build();
    }
}
