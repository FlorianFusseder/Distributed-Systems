/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.fusseder.paper5.exercise0.Entitys;

/**
 *
 * @author Florian Fußeder
 */
public class Wunsch {

	private String was;
	private int menge;

	public Wunsch() {
	}

	public Wunsch(String was, int menge) {
		this.was = was;
		this.menge = menge;
	}

	public String getWas() {
		return was;
	}

	public void setWas(String was) {
		this.was = was;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}
}
