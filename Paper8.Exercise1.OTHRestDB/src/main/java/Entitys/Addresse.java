/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Florian Fußeder
 */
@XmlRootElement
public class Addresse {

	private String strasse;
	private String ort;

	public Addresse() {
	}

	public Addresse(String strasse, String ort) {
		this.strasse = strasse;
		this.ort = ort;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 59 * hash + Objects.hashCode(this.strasse);
		hash = 59 * hash + Objects.hashCode(this.ort);
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
		final Addresse other = (Addresse) obj;
		if (!Objects.equals(this.strasse, other.strasse)) {
			return false;
		}
		if (!Objects.equals(this.ort, other.ort)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Addresse{" + "strasse=" + strasse + ", ort=" + ort + '}';
	}
	
	
}
