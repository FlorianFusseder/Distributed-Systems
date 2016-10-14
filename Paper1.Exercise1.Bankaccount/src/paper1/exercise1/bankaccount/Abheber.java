/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper1.exercise1.bankaccount;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian Fußeder
 */
public class Abheber extends Thread
{

    private Account acc;

    public Abheber(Account acc)
    {
        this.acc = acc;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            acc.Abheben(10000);
            
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(Abheber.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
