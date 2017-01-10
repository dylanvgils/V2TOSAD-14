package services;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldService {
    @GET
    @Produces("text/plain")
    public Response sayHello() {
        STGroup stGroup = new STGroupFile("text.stg");
        ST templateExample = stGroup.getInstanceOf("templateExample");
        templateExample.add("param", "Hello World");
        return Response.status(200).entity(templateExample.render()).build();
    }
}
