/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.fusseder.paper5.exercise0.Services;

import de.othr.fusseder.paper5.exercise0.Entitys.Wunsch;
import de.othr.fusseder.paper5.exercise0.Entitys.WunschZettel;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Florian Fußeder
 */
@Path("wunschzettel")
public class GeschenkeService {
	
	private static int WUNSCHZETTEL_NR = 1;
	
	private Map<Integer, WunschZettel> alleZettel = new HashMap<>();
	
	@GET
	@Path("{wzid}")
	public WunschZettel zeigeZettel(@PathParam("{wzid}") int zettelNr){
		System.out.println("Angeforder ist: " + alleZettel.get(zettelNr));
		return alleZettel.get(zettelNr);
	}
	
	@POST
	public WunschZettel wunschzettelAbgeben(WunschZettel wunschZettel){
		System.out.println("Wunschzettel abegeben: " + wunschZettel);
		return wunschZettel;
	}
	
	@PUT
	@Path("{wzid}")
	public void wunschErgaenzen(Wunsch wunsch, @PathParam("wzid") int WunschzettelId){
		System.out.println("Wunsch " + wunsch + " an Wunschzettel " + WunschzettelId + " hinzugefügt");
	}
	
	@DELETE
	@Path("{wzid}")
	public void wunschzettelStornieren(int WunschzettelId){
		System.out.println("Wunschzettel" + WunschzettelId + " verbrannt");
	}
	
	public void addWunschZettel(WunschZettel w){
		this.alleZettel.put(WUNSCHZETTEL_NR++, w);
	}
	
}
