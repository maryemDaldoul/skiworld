package WebServices;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.entities.Menu;

import tn.esprit.services.GestionMenuLocal;


@Path("menu")
@RequestScoped

public class MenuRessources {
@EJB
 GestionMenuLocal local;
//GestionRestoLocal local1;

@GET
@Produces("application/json")
public  Response getAll(){
	//return Response.status(Status.OK).entity(local.getAll()).build();
	return Response.status(Status.OK)
			.entity(local.getAll())
			.build();
}

@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response add(Menu menu)

{
	if(local.add( menu))
	return Response.status(Status.CREATED).build();
	return Response.status(Status.NOT_FOUND).build();
}



	
	//@POST
	//@Produces("application/json")
	//public Response add(Menu menu)
	
	//{
	//	if(local.add( menu))
	//		return Response.status(Status.CREATED).build();
	//	return Response.status(Status.NOT_FOUND).build();
	//}
////////////////just pour le test du post////
	//@POST
	//@Consumes(MediaType.APPLICATION_JSON)

	//public Response add(Menu menu)
	
	//{
		//return Response.status(Status.OK).entity(local1.add( menu))
			//	.build();
	//}
	}

	

