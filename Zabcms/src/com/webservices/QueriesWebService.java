package com.webservices;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dal.Documentsdao;
import com.dal.Queriesdao;
import com.model.Documentsdto;
import com.model.Queriesdto;


public class QueriesWebService {
	@Path("/qew")
	public class DocumentsWebService {
		
			@GET
			@Path("/{queriesid}/{text}")
		public Response printMessage(@PathParam("queriesid") int queriesid,
				@PathParam("text")String text 
			){
				Queriesdao qdao =new Queriesdao();
				Queriesdto qdto =new Queriesdto();
				
			qdao.create();
			qdao.update();
			qdto.setQueriesid(queriesid);
			qdto.setText(text);
			String result= "Queries id and Query ="+queriesid+""+text;
				return Response.status(200).entity(result).build() ;
				
			}
		}

}
