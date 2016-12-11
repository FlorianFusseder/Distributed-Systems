/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.fusseder.paper5.exercise0.Services;

import de.othr.fusseder.paper5.exercise0.Entitys.Wunsch;
import de.othr.fusseder.paper5.exercise0.Entitys.WunschZettel;
import de.othr.fusseder.paper5.exercise0.Persistence.Persistence;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Florian Fußeder
 */
@Path("wunschzettel")
public class GeschenkeService {
	
	private static int WUNSCHZETTEL_NR = 1;

	public GeschenkeService() {
		
	}
	
	
	
	@GET
	@Path("/{wzid}")
	@Produces(MediaType.APPLICATION_JSON)
	public WunschZettel zeigeZettel(@PathParam("wzid") int zettelNr){
		System.out.println("Angeforder ist: " + Persistence.alleZettel.get(zettelNr));
		return Persistence.alleZettel.get(zettelNr);
	}
	
	@POST
	public void wunschzettelAbgeben(WunschZettel w){

		WunschZettel a = new WunschZettel();
		a.setName(w.getName());
		a.setBravheitsIndex(w.getBravheitsIndex());
		a.setWuensche(w.getWuensche());
		
		
		System.out.println("Wunschzettel abegeben: " + a);
		Persistence.alleZettel.put(WUNSCHZETTEL_NR++, a);
	}
	
	@PUT
	@Path("/{wzid}")
	public void wunschErgaenzen(Wunsch wunsch, @PathParam("wzid") int WunschzettelId){
		System.out.println("Wunsch " + wunsch + " an Wunschzettel " + WunschzettelId + " hinzugefügt");
	}
	
	@DELETE
	@Path("/{wzid}")
	public void wunschzettelStornieren(@PathParam("wzid") int WunschzettelId){
		
		Persistence.alleZettel.remove(WunschzettelId);
		System.out.println("Wunschzettel" + WunschzettelId + " verbrannt");
		
	}
}
