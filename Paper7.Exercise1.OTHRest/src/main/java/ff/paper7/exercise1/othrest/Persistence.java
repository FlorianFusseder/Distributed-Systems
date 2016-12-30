/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff.paper7.exercise1.othrest;

import Entitys.Address;
import Entitys.ListOfStudents;
import Entitys.Student;
import java.io.File;
import java.util.Arrays;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Florian
 */
public class Persistence {

	public Persistence() {
	}

	public static void build() {
		ListOfStudents los = new ListOfStudents();
		Student[] arr = {
			new Student.Builder("1")
			.firstName("Florian")
			.lastName("Fusseder")
			.ects(32)
			.address(new Address("langenkatzbach", "Gankofen"))
			.build(),
			new Student.Builder("2")
			.firstName("Floyd")
			.lastName("Kretschmar")
			.ects(3232)
			.address(new Address("Regensburg", "Regensburg"))
			.build(),};

		Persistence.save(arr);

	}

	public static void add(Student student) {
		Student[] s = getArr();

		Student[] sNew = Arrays.copyOf(s, s.length + 1);
		sNew[sNew.length - 1] = student;

		save(sNew);
	}

	public static Student[] getArr() {

		try {
			File f = new File("classes.txt");

			JAXBContext jaxbc = JAXBContext.newInstance(ListOfStudents.class);
			Unmarshaller m = jaxbc.createUnmarshaller();
			return ((ListOfStudents) m.unmarshal(f)).getArr();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Student getStudent(int i) {

		Student[] arr = getArr();
		if (arr.length > i) {
			return getArr()[i];
		}
		return null;
	}

	public static void save(Student[] s) {
		try {
			File f = new File("classes.txt");
			ListOfStudents los = new ListOfStudents();
			los.setArr(s);

			JAXBContext jaxbc = JAXBContext.newInstance(ListOfStudents.class);
			Marshaller m = jaxbc.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(los, f);
			System.out.println("done");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
