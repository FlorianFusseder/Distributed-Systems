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
	private Address address;

	public Student() {
	}

	private Student(Builder b) {
		this.matrNr = b.matrNr;
		this.address = b.adress;
		this.firstName = b.firstName;
		this.lastName = b.lastName;
		this.etcs = b.etcs;
	}

	public static class Builder {

		private String matrNr;
		private String firstName;
		private String lastName;
		private int etcs;
		private Address adress;

		public Builder(String matrNr) {
			this.matrNr = matrNr;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder ects(int ects) {
			this.etcs = ects;
			return this;
		}

		public Builder address(Address address) {
			this.adress = address;
			return this;
		}

		public Student build() {
			return new Student(this);
		}

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

	public Address getAdress() {
		return address;
	}

	public void setAdress(Address adress) {
		this.address = adress;
	}
}
