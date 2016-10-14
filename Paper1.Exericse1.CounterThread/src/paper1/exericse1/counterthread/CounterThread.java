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
public class CounterThread extends Thread
{
    private String s;

    public CounterThread(String s)
    {
        this.s = s;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println(s + " -> " + i);
        }
    }
    
    
    
}
