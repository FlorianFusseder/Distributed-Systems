/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper1.exercise1.bankaccount;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Florian Fußeder
 */
public class Account
{

    private long ct;
    private final Lock l;

    public Account(long ct)
    {
        this.ct = ct;
        this.l = new ReentrantLock();
    }

    public long getCt()
    {
        return ct;
    }

    public /*synchronized*/ void Einzahlen(long betrag)
    {
        l.lock();
        try
        {
            ct += betrag;
        } finally
        {
            l.unlock();
        }
    }

    public /*synchronized*/ void Abheben(long betrag)
    {
        l.lock();
        try
        {
            ct -= betrag;
        } finally
        {
            l.unlock();
        }
    }

    @Override
    public String toString()
    {
        return "Account{" + "ct=" + ct + '}';
    }
    
    
}
