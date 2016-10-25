/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leberkassemmel;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class Student extends Thread
{

    private KitchenCounter theke;
    private String objectName;

    public Student(KitchenCounter theke, String string)
    {
        this.theke = theke;
        this.objectName = string;
        this.setName(string);
    }

    public KitchenCounter getTheke()
    {
        return theke;
    }

    public void setTheke(KitchenCounter theke)
    {
        this.theke = theke;
    }

    public String getObjectName()
    {
        return objectName;
    }

    public void setObjectName(String objectName)
    {
        this.objectName = objectName;
    }   
    
    
    @Override
    public void run()
    {
        while (true)
        {
            theke.take();
//            try
//            {
//                sleep(50);
//            } catch (InterruptedException ex)
//            {
//                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }

    }

    @Override
    public String toString()
    {
        return "Student{" + "objectName=" + objectName + '}';
    }

}
