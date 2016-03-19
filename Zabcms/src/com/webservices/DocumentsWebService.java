package com.webservices;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dal.Documentsdao;
import com.model.Documentsdto;

@Path("/dcw")
public class DocumentsWebService {
	
		@GET
		@Path("/{documentsid}/{documentsname}")
	public Response printMessage(@PathParam("documentsid") int documentsid,
			@PathParam("documentsname")String documentsname 
		){
			Documentsdao docdao =new Documentsdao();
			Documentsdto docdto =new Documentsdto();
			
		docdao.create();
		docdao.update();
		docdto.setDocumentsid(documentsid);
		docdto.setDocumentname(documentsname);
		String result= "Document name and Document id ="+documentsname+""+documentsid;
			return Response.status(200).entity(result).build() ;
			
		}
	}


