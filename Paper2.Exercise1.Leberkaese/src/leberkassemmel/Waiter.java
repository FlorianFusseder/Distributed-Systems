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
public class Waiter extends Thread
{

    private KitchenCounter theke;
    private String objectName;

    Waiter(KitchenCounter theke, String kellner)
    {
        this.theke = theke;
        this.objectName = kellner;
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
            try
            {
                sleep((long) (Math.random() * 3000));
            } catch (InterruptedException e)
            {
                /* ignorieren */
            }
            theke.put();
            System.out.println(toString() + " did put a semme");

        }
    }

    @Override
    public String toString()
    {
        return "Waiter{" + "objectName=" + objectName + '}';
    }

}
