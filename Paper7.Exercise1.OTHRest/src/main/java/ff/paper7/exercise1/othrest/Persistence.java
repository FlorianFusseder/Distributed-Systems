/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff.paper7.exercise1.othrest;

import Entitys.Adress;
import Entitys.Student;
import java.util.Arrays;

/**
 *
 * @author Florian
 */
public class Persistence {

	private static Student[] arr = {
		new Student("1", "Florian", "Fusseder", 34, new Adress("Brunhuber", "Regensburg")),
		new Student("2", "Floyd", "Kretschmar", 120, new Adress("Galben", "Regensburg")),
		new Student("3", "Sonja", "Rietig", 50, new Adress("Studenten", "Regensburg")),
		new Student("4", "Sebastian", "Nuss", 77, new Adress("See", "Regensburg")),
		new Student("5", "Sebstian", "Sidortschuck", 98, new Adress("Sauf", "Regensburg"))
	};

	public Persistence() {
	}

	public static Student[] getArr() {
		return arr;
	}

	public static String output() {
		return Arrays.asList(arr).toString();
	}
	
	
}
