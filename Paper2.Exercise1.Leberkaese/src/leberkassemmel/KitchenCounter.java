/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leberkassemmel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class KitchenCounter
{

    private final int capaticy;
    private int counter;
    Lock lock = new ReentrantLock();
    Condition volleTheke = lock.newCondition();
    Condition leereTheke = lock.newCondition();

    KitchenCounter(int capaticy)
    {
        this.capaticy = capaticy;
        counter = 0;
    }


    public void put()
    {
        lock.lock();
        try
        {
            while(counter == capaticy)
                try
                {
                    leereTheke.await();
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(KitchenCounter.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.counter++;
            System.out.println(Thread.currentThread().getName() + " " + toString());
            volleTheke.signal();
        } finally
        {
            lock.unlock();
        }
    }

    public void take()
    {
        lock.lock();
        try
        {
            while(counter == 0)
                try
                {
                    volleTheke.await();
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(KitchenCounter.class.getName()).log(Level.SEVERE, null, ex);
                }
            this.counter--;
            System.out.println(Thread.currentThread().getName() + " " + toString());
            leereTheke.signal();
        } finally
        {
            lock.unlock();
        }
    }

    @Override
    public String toString()
    {
        return "KitchenCounter{" + "capaticy=" + capaticy + ", counter=" + counter + '}';
    }
    
    
}
