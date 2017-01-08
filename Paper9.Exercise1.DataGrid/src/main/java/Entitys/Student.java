/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import java.io.IOException;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Florian Fußeder
 */
@XmlRootElement
public class Student implements Portable {
	
	public final static int ID = 5;

	private int matrikelNr;
	private String vorname;
	private String nachname;
	private int etcs;
	Addresse addresse;

	public Student() {
	}

	private Student(Builder b) {
		this.matrikelNr = b.matrikelNr;
		this.vorname = b.vorname;
		this.nachname = b.nachname;
		this.etcs = b.ects;
		this.addresse = b.addresse;
	}

	@Override
	public int getFactoryId() {
		return 1;
	}

	@Override
	public int getClassId() {
		return ID;
	}

	@Override
	public void writePortable(PortableWriter writer) throws IOException {
		writer.writeInt("matr", matrikelNr);
		writer.writeUTF("vorname", this.vorname);
		writer.writeUTF("nachname", this.nachname);
		writer.writeInt("ects", this.etcs);
		writer.writeUTF("ort", this.addresse.getOrt());
		writer.writeUTF("strasse", this.addresse.getStrasse());
	}

	@Override
	public void readPortable(PortableReader reader) throws IOException {
		this.matrikelNr=reader.readInt("matr");
		this.vorname=reader.readUTF("vorname");
		this.nachname=reader.readUTF("nachname");
		this.etcs=reader.readInt("ects");
		this.addresse = new Addresse(reader.readUTF("ort"), reader.readUTF("strasse"));
	}

	public static class Builder {

		private int matrikelNr;
		private String vorname;
		private String nachname;
		private int ects;
		Addresse addresse;

		public Builder(int Nummer) {
			this.matrikelNr = Nummer;
		}

		public Builder vorname(String vorname) {
			this.vorname = vorname;
			return this;
		}

		public Builder nachname(String nachname) {
			this.nachname = nachname;
			return this;
		}

		public Builder ects(int ects) {
			this.ects = ects;
			return this;
		}

		public Builder addresse(Addresse addresse) {
			this.addresse = addresse;
			return this;
		}

		public Student build() {
			return new Student(this);
		}

	}

	public int getMatrielNr() {
		return matrikelNr;
	}

	public void setMatrielNr(int matrielNr) {
		this.matrikelNr = matrielNr;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public int getEtcs() {
		return etcs;
	}

	public void setEtcs(int etcs) {
		this.etcs = etcs;
	}

	public Addresse getAddresse() {
		return addresse;
	}

	public void setAddresse(Addresse addresse) {
		this.addresse = addresse;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 19 * hash + this.matrikelNr;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Student other = (Student) obj;
		return this.matrikelNr == other.matrikelNr;
	}

	@Override
	public String toString() {
		return "Student{" + "matrielNr=" + matrikelNr + ", vorname=" + vorname + ", nachname=" + nachname + ", etcs=" + etcs + ", addresse=" + addresse + '}';
	}
}
