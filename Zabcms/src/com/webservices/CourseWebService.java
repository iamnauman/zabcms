package com.webservices;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.model.Coursesdto;
@Path("/cvb")
public class CourseWebService {
	
	
@GET
@Path("/produce/{param}")
@Produces(MediaType.APPLICATION_JSON)
	public Response getJson(@PathParam("param") String cnum , String cname, 
			String docid, String depid){
		final Coursesdto crsedto = new Coursesdto(cnum, cname, docid, depid);
		return Response.status(200).entity(crsedto).build();
}
	@GET
	@Path("/{param}")
public Response printMessage(@PathParam("param") String cnum, 
	String cname, String docid, String depid){
	String result =" Courses says : "+cnum;
//	String result1 =" Courses says : "+cname ;
//	String result2 =" Courses says : "+docid;
//	String result3 =" Courses says : "+depid;
//	
		return Response.status(200).entity(result).build() ;
		
	}
}

