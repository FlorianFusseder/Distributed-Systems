/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Florian Fußeder
 */
@XmlRootElement
public class ListOfStudents {

	private Student[] arr;

	public ListOfStudents() {
	}

	public Student[] getArr() {
		return arr;
	}

	public void setArr(Student[] arr) {
		this.arr = arr;
	}

}
