/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Florian Fußeder
 */
@XmlRootElement
public class Student {

	private int matrielNr;
	private String vorname;
	private String nachname;
	private int etcs;
	Addresse addresse;

	public Student() {
	}

	public Student(int matrielNr, String vorname, String nachname, int etcs, Addresse addresse) {
		this.matrielNr = matrielNr;
		this.vorname = vorname;
		this.nachname = nachname;
		this.etcs = etcs;
		this.addresse = addresse;
	}

	public int getMatrielNr() {
		return matrielNr;
	}

	public void setMatrielNr(int matrielNr) {
		this.matrielNr = matrielNr;
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
		hash = 19 * hash + this.matrielNr;
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
		return this.matrielNr == other.matrielNr;
	}

	@Override
	public String toString() {
		return "Student{" + "matrielNr=" + matrielNr + ", vorname=" + vorname + ", nachname=" + nachname + ", etcs=" + etcs + ", addresse=" + addresse + '}';
	}
}
