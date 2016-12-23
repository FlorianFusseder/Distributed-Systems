/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Florian
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

	@XmlAttribute(name = "Matrikelnummer")
	private String matrNr;
	private String firstName;
	private String lastName;
	private int etcs;
	private Adress adress;

	public Student() {
	}

	public Student(String matrNr, String firstName, String lastName, int etcs, Adress adress) {
		this.matrNr = matrNr;
		this.firstName = firstName;
		this.lastName = lastName;
		this.etcs = etcs;
		this.adress = adress;
	}

	public String getMatrNr() {
		return matrNr;
	}

	public void setMatrNr(String matrNr) {
		this.matrNr = matrNr;
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
