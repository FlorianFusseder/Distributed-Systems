/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitys.Pruefungsleistung;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Florian Fußeder
 */
@Path("pruenfung")
public class PruefungsleistungsService {

	public PruefungsleistungsService() {
	}

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void producePruefungsLeistung(Pruefungsleistung pruefung) {

		try (Connection c
				= DriverManager.getConnection("jdbc:mysql://im-vm-011:3306/vs-08", "vs-08", "vs-08-pw")) {

			try {

				c.setAutoCommit(false);
				this.ouputAllData(c);

				PreparedStatement insertStatement = c.prepareStatement(
						"INSERT INTO Pruefungsleistung (pruefungId, matrikelNr, versuch, note) VALUES "
						+ "(?, ?, ?, ?)");

				PreparedStatement updateStatement = c.prepareStatement("Update Student  "
						+ "Set ects=ects+? where matrikelNr=?");

				PreparedStatement getPruefungStatment = c.prepareStatement("select * "
						+ "from Pruefung where pruefungId=?");

				insertStatement.setString(1, pruefung.getPruefungsId());
				insertStatement.setInt(2, pruefung.getMatrikelNr());
				insertStatement.setInt(3, pruefung.getVersuch());
				insertStatement.setDouble(4, pruefung.getNote());

				getPruefungStatment.setString(1, pruefung.getPruefungsId());

				ResultSet resultSet = getPruefungStatment.executeQuery();
				if (resultSet.next()) {
					updateStatement.setInt(1, resultSet.getInt("ects"));
					updateStatement.setInt(2, pruefung.getMatrikelNr());
				} else {
					throw new SQLDataException("Pruefung not found");
				}

				updateStatement.executeUpdate();
				insertStatement.executeUpdate();

			} catch (SQLException e) {
				c.rollback();
				System.out.println(e.getMessage());
			} finally {
				c.commit();
				this.ouputAllData(c);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void ouputAllData(Connection c) throws SQLException {

		Statement stmt = c.createStatement();
		ResultSet set = stmt.executeQuery("Select * from Student");

		while (set.next()) {
			System.out.println(set.getString("nachname") + ", " + set.getString("vorname")
					+ " -> " + set.getString("ects"));
		}

		set = stmt.executeQuery("select * from Pruefungsleistung");

		while (set.next()) {
			System.out.println(set.getInt("id") + " "
					+ set.getString("pruefungId") + " "
					+ set.getInt("matrikelNr") + " "
					+ set.getInt("versuch") + " "
					+ set.getDouble("note"));
		}

		set = stmt.executeQuery("select * from Pruefung");

		while (set.next()) {
			System.out.println(set.getString("pruefungId") + ", ects: " + set.getInt("ects"));
		}

		System.out.println("\n");

	}
}
