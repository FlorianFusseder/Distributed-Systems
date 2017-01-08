/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.Addresse;
import Entitys.Student;
import com.hazelcast.core.ReplicatedMap;
import ff.paper9.exercise1.datagrid.main;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.concurrent.TimeUnit;
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

	private static final Logger logger = Logger.getLogger(StudentenService.class.getName());

	;

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

		logger.info("Student mit Id:" + Id + " holen");

		ReplicatedMap<Integer, Student> students = main.hazelcast.getReplicatedMap("m");

		if (students.containsKey(Id)) {
			logger.info("Found Student in Hazelcast");
			return students.get(Id);
		}

		logger.info("Didn't find Student, starting to search in DB");

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
				logger.info("Student mit Id:" + Id + " holen");
				Student s = new Student.Builder(set.getInt(1))
						.vorname(set.getString(2))
						.nachname(set.getString(3))
						.ects(set.getInt(4))
						.addresse(new Addresse(set.getString(5), set.getString(6)))
						.build();

				students.put(s.getMatrielNr(), s, 10, TimeUnit.SECONDS);
				
				return s;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		logger.severe("No student found");
		return null;
	}
}
