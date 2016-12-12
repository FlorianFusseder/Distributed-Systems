/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entitys.Student;
import ff.paper7.exercise1.othrest.Persistence;
import java.io.Serializable;
import java.util.Arrays;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Florian
 */
@Path("webresoures")
public class StudentService implements Serializable{

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Student/{id}")
	public Student getStudentById(@PathParam("id") int id) {
		Student s = Persistence.getArr()[id];
		System.out.println("Returning: " + s.toString());
		return s;
	}

	@DELETE
	@Path("/Student/{id}")
	public void deleteStudentById(@PathParam("id") int id) {
		System.out.println("Deleting: " + Persistence.getArr()[id].toString());
		Persistence.getArr()[id] = null;
		
		System.out.println(Persistence.output());
	}

	@GET
	@Path("/Student/{from}/{to}")
	public Student[] getStudentsByIdRange(@PathParam("from") int from, @PathParam("to") int to) {
		System.out.println("Returing range: " + from + " - " + to);
		return Arrays.copyOfRange(Persistence.getArr(), from, to);
	}

}
