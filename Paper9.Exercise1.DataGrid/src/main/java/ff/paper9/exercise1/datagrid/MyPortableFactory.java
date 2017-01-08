/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff.paper9.exercise1.datagrid;

import Entitys.Student;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;

/**
 *
 * @author Florian
 */
public class MyPortableFactory implements PortableFactory{

	@Override
	public Portable create(int i) {
		if(Student.ID == i)
			return new Student();
		else 
			return null;
	}
	
}
