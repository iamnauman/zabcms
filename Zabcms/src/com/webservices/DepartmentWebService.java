package com.webservices;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dal.Departmentdao;
import com.dal.Userdao;
import com.model.Coursesdto;
import com.model.Departmentdto;
@Path("/dpw")
public class DepartmentWebService {
	
	@GET
	@Path("/produce/{param}")
	@Produces(MediaType.APPLICATION_JSON)
		public Response getJson(@PathParam("param") String cnum , String cname, 
				String docid, String depid){
			final Coursesdto crsedto = new Coursesdto(cnum, cname, docid, depid);
			return Response.status(200).entity(crsedto).build();
	}
		@GET
		@Path("/{departmentid}/{departmentname}")
	public Response printMessage(@PathParam("departmentid") int departmentid,
			@PathParam("departmentname")String departmentname 
		){
			Departmentdao depdao =new Departmentdao();
			Departmentdto depdto =new Departmentdto();
			
		depdao.create();
		depdao.update();
		depdto.setDepartmentid(departmentid);
		depdto.setDepartmentname(departmentname);
		String result= "Department name and Department id ="+departmentname+""+departmentid;
			return Response.status(200).entity(result).build() ;
			
		}
	}


