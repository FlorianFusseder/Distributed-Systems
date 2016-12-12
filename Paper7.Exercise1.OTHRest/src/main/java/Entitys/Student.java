/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

/**
 *
 * @author Florian
 */
public class Student {

	private String mnr;
	private String firstName;
	private String lastName;
	private int etcs;
	private Adress adress;

	public Student() {
	}

	public Student(String mnr, String firstName, String lastName, int etcs, Adress adress) {
		this.mnr = mnr;
		this.firstName = firstName;
		this.lastName = lastName;
		this.etcs = etcs;
		this.adress = adress;
	}

	public String getMnr() {
		return mnr;
	}

	public void setMnr(String mnr) {
		this.mnr = mnr;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEtcs() {
		return etcs;
	}

	public void setEtcs(int etcs) {
		this.etcs = etcs;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}
}
