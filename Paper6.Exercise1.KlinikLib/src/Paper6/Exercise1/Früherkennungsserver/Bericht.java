/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paper6.Exercise1.Früherkennungsserver;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Florian
 */
public class Bericht implements Serializable{

	private Date datum;
	private String diagnose;
	private String weiteresVorgehen;

	public Bericht() {
	}

	public Bericht(Date datum, String diagnose, String weiteresVorgehen) {
		this.datum = datum;
		this.diagnose = diagnose;
		this.weiteresVorgehen = weiteresVorgehen;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getWeiteresVorgehen() {
		return weiteresVorgehen;
	}

	public void setWeiteresVorgehen(String weiteresVorgehen) {
		this.weiteresVorgehen = weiteresVorgehen;
	}

	@Override
	public String toString() {
		return "Bericht{" + "datum=" + datum + ", diagnose=" + diagnose + ", weiteresVorgehen=" + weiteresVorgehen + '}';
	}
	
}
