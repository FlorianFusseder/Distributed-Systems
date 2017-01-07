/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.util.Objects;

/**
 *
 * @author Florian Fußeder
 */
public class Pruefungen {
	
	private String pruefungId;
	private String bezeichnung;
	private int etcs;

	public Pruefungen() {
	}

	public Pruefungen(String pruefungId, String bezeichnung, int etcs) {
		this.pruefungId = pruefungId;
		this.bezeichnung = bezeichnung;
		this.etcs = etcs;
	}

	public String getPruefungId() {
		return pruefungId;
	}

	public void setPruefungId(String pruefungId) {
		this.pruefungId = pruefungId;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getEtcs() {
		return etcs;
	}

	public void setEtcs(int etcs) {
		this.etcs = etcs;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 67 * hash + Objects.hashCode(this.pruefungId);
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
		final Pruefungen other = (Pruefungen) obj;
		if (!Objects.equals(this.pruefungId, other.pruefungId)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Pruefungen{" + "pruefungId=" + pruefungId + ", bezeichnung=" + bezeichnung + ", etcs=" + etcs + '}';
	}
	
	
}
