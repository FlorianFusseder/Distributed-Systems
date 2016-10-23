package paper1.exercise3.parkhaus;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Florian Fußeder
 */
class Parkhaus
{

    private final int capaticy;
    private int counter;
    
    Parkhaus(int capaticy)
    {
        this.capaticy = capaticy;
        this.counter = 0;
    }

    void einfahren()
    {
        synchronized(this){
            while(counter >= capaticy)
                try
                {
                    wait();
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(Parkhaus.class.getName()).log(Level.SEVERE, null, ex);
                }
            counter++;
            System.out.println(toString());
            
        }
    }

    void ausfahren()
    {
        synchronized (this){
            counter--;
            notify();
            System.out.println(toString());
        }
    }

    @Override
    public String toString()
    {
        return "Parkhaus{" + "capaticy=" + capaticy + ", counter=" + counter + '}';
    }
    
}
