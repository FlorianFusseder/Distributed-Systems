/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.Addresse;
import Entitys.Student;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Florian Fußeder
 */
@Path("students")
public class StudentenService implements Serializable {

	public StudentenService() {
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Student getStudent(@PathParam("id") int Id) {
		return GetStudentById(Id);
	}
	
	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentQuery(@QueryParam("id") int Id) {
		return GetStudentById(Id);
	}

	private Student GetStudentById(int Id) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(StudentenService.class.getName()).log(Level.SEVERE, null, ex);
		}

		try (Connection c = DriverManager.getConnection("jdbc:mysql://im-vm-011:3306/vs-08", "vs-08", "vs-08-pw")) {

			Statement stmt = c.createStatement();
			String query = "Select * from Student where matrikelNr = " + Id;
			ResultSet set = stmt.executeQuery(query);

			if (set.next()) {
				return new Student.Builder(set.getInt(1))
						.vorname(set.getString(2))
						.nachname(set.getString(3))
						.ects(set.getInt(4))
						.addresse(new Addresse(set.getString(5), set.getString(6)))
						.build();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		return null;
	}
}
