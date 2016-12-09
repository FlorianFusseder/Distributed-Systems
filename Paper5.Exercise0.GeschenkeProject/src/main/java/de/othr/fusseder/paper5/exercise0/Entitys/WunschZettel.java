/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.fusseder.paper5.exercise0.Entitys;

import java.util.List;

/**
 *
 * @author Florian Fußeder
 */
public class WunschZettel {
	
	private int	id;
	private String name;
	private double bravheitsIndex;
	private List<Wunsch> wuensche;

	public WunschZettel() {
	}

	public WunschZettel(String name, double bravheitsIndex, List<Wunsch> wuensche) {
		this.name = name;
		this.bravheitsIndex = bravheitsIndex;
		this.wuensche = wuensche;
	}
	
	public void addWunsch(Wunsch wunsch){
		this.wuensche.add(wunsch);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBravheitsIndex() {
		return bravheitsIndex;
	}

	public void setBravheitsIndex(double bravheitsIndex) {
		this.bravheitsIndex = bravheitsIndex;
	}

	public List<Wunsch> getWuensche() {
		return wuensche;
	}

	public void setWuensche(List<Wunsch> wuensche) {
		this.wuensche = wuensche;
	}
	
	
	
}
