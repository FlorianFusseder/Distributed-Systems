/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Florian Fußeder
 */
@XmlRootElement
public class Pruefungsleistung implements Serializable {

	private int id;
	private String pruefungsId;
	private int matrikelNr;
	private int versuch;
	private double note;

	public Pruefungsleistung() {
	}

	public Pruefungsleistung(String pruefungsId, int matrikelNr, int versuch, double note) {
		this.pruefungsId = pruefungsId;
		this.matrikelNr = matrikelNr;
		this.versuch = versuch;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPruefungsId() {
		return pruefungsId;
	}

	public void setPruefungsId(String pruefungsId) {
		this.pruefungsId = pruefungsId;
	}

	public int getMatrikelNr() {
		return matrikelNr;
	}

	public void setMatrikelNr(int matrikelNr) {
		this.matrikelNr = matrikelNr;
	}

	public int getVersuch() {
		return versuch;
	}

	public void setVersuch(int versuch) {
		this.versuch = versuch;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 17 * hash + this.id;
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
		final Pruefungsleistung other = (Pruefungsleistung) obj;
		return this.id == other.id;
	}

	@Override
	public String toString() {
		return "Pruefungsleistung{" + "id=" + id + ", pruefungsId=" + pruefungsId + ", matrikelNr=" + matrikelNr + ", versuch=" + versuch + ", note=" + note + '}';
	}

}
