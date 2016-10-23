/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leberkassemmel;

/**
 *
 * @author Florian
 */
public class Leberkassemmel
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        KitchenCounter theke = new KitchenCounter(4);
        new Waiter(theke, "Kellner-1").start();
        new Waiter(theke, "Kellner-2").start();
        
        for (int i = 1; i < 8; i++)
            new Student(theke, "Student-" +i).start();
    }
    
}
