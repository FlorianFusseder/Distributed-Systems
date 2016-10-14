/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper1.exericse1.counterthread;

/**
 *
 * @author Florian Fußeder
 */
public class Paper1Exericse1CounterThread
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new CounterThread("Counter 1").start();
        new CounterThread("Counter 2").start();
        new CounterThread("Counter 3").start();
        new CounterThread("Counter 4").start();
    }
    
}
