package com.webservices;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.dal.Userdao;
import com.model.Userdto;
@Path("/lgnserv")
public class LoginService {
	
	
//	@GET
//	@Path("/produce/{paachacaaram}")
//	@Produces(MediaType.APPLICATION_JSON)
//		public Response getJson(@PathParam("param") String username,String password){
//			final Userdto usrdto = new Userdto(username, password);
//			return Response.status(200).entity(usrdto).build();
//	}
		@GET
		@Path("/{username}/{password}")
	public Response printMessage(@PathParam("username")String username, @PathParam("password") String password  ){
			Userdto userdto =new Userdto();
//		Userdao usrdao=new Userdao();
		
//		usrdao.retrieve();
			userdto.setFull_name(username);
			userdto.setPassword(password);
//		System.out.println("Users username and Password"+username);
		String result = "Username and Password is :"+username+""+password;
			return Response.status(200).entity("Get users username & password"+result).build() ;
			
			
		}}
	


