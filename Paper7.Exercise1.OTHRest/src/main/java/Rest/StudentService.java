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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Florian
 */
@Path("students")
public class StudentService implements Serializable {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("")
	public Student[] getAllStudents() {
		return Persistence.getArr();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("student/{id}")
	public Student getStudentById(@PathParam("id") int id) {
		Student s = Persistence.getArr()[id];
		System.out.println("Returning: " + s.toString());
		return s;
	}

	@GET
	@Path("student/{from}/{to}")
	@Produces(MediaType.APPLICATION_XML)
	public Student[] getStudentsByIdRange(@PathParam("from") int from, @PathParam("to") int to) {
		System.out.println("Returning range: " + from + " - " + to);
		return Arrays.copyOfRange(Persistence.getArr(), from, to);
	}

	@GET
	@Path("student")
	@Produces(MediaType.APPLICATION_XML)
	public Student[] getStudentsByIdRangeQ(@QueryParam("from") int from, @QueryParam("to") int to) {
		System.out.println("Returning range: " + from + " - " + to);
		return Arrays.copyOfRange(Persistence.getArr(), from, to);
	}

	@DELETE
	@Path("student/{id}")
	public void deleteStudentById(@PathParam("id") int id) {
		System.out.println("Deleting: " + Persistence.getArr()[id].toString());
		Student[] s = Persistence.getArr();

		if (s.length > id) {
			s[id] = null;
			Persistence.save(s);
		}

	}

	@POST
	@Path("newStudent")
	@Consumes(MediaType.APPLICATION_XML)
	public void createStudent(Student s) {

		Student student = new Student.Builder(s.getMatrNr())
				.firstName(s.getFirstName())
				.lastName(s.getLastName())
				.ects(s.getEtcs())
				.address(s.getAdress())
				.build();
		
		Persistence.add(student);
		
	}

}
