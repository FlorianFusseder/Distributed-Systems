/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper6.exercise1.Früherkennungsserver;

import Paper6.Exercise1.Früherkennungsserver.IRoentgenbild;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author Florian
 */
public class Roentgenbild implements IRoentgenbild {

	private Date aufnahmeDatum;
	transient private String patientenname;
	private byte[] rawData;

	public Roentgenbild() {
	}

	public Roentgenbild(Date aufnahmeDatum, String patientenname, byte[] rawData) {
		this.aufnahmeDatum = aufnahmeDatum;
		this.patientenname = patientenname;
		this.rawData = rawData;
	}

	@Override
	public byte[] showPicture() {
		return this.rawData;
	}

	@Override
	public void setDate(Date d) throws RemoteException {
		this.aufnahmeDatum = d;
	}

	public Date getAufnahmeDatum() {
		return aufnahmeDatum;
	}

	public void setAufnahmeDatum(Date aufnahmeDatum) {
		this.aufnahmeDatum = aufnahmeDatum;
	}

	public String getPatientenname() {
		return patientenname;
	}

	public void setPatientenname(String patientenname) {
		this.patientenname = patientenname;
	}

	public byte[] getRawData() {
		return rawData;
	}

	public void setRawData(byte[] rawData) {
		this.rawData = rawData;
	}

	@Override
	public Date getDate() throws RemoteException {
		return this.aufnahmeDatum;
	}
	
	

}
