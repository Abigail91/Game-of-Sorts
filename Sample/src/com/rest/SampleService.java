package com.rest;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;


import Dragon.dragon;



@ApplicationPath("rest")
@Path("sample")
public class SampleService extends Application {

	@GET
	@Path("generar")
	@Produces("application/xml")
	
	public List<dragon> generarOleada(@QueryParam("value") int value){
		
		List<dragon> lista = new ArrayList<dragon>();
		
		for(int i = 0; i <= value; i++) {
		dragon p = new dragon();
		  lista.add(p);
		  
		}
		  
		  return lista;
		  
	}

	@GET
	@Path("ordenar")
	@Produces("application/xml")
	public List<dragon> ordenarOleada(@QueryParam("oleada") List<dragon> lista_ordenada) {
		return lista_ordenada;
	}
}
 
	
	
	
