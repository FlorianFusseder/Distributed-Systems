/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leberkassemmel;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class Waiter extends Thread
{

    private KitchenCounter theke;
    private String objectName;

    Waiter(KitchenCounter theke, String kellner)
    {
        this.theke = theke;
        this.objectName = kellner;
        this.setName(kellner);
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
            theke.put();
//            try
//            {
//                sleep(50);
//            } catch (InterruptedException ex)
//            {
//                Logger.getLogger(Waiter.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

    @Override
    public String toString()
    {
        return "Waiter{" + "objectName=" + objectName + '}';
    }

}
