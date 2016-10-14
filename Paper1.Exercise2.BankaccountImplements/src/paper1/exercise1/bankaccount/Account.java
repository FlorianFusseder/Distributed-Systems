/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper1.exercise1.bankaccount;

/**
 *
 * @author Florian Fußeder
 */
public class Account
{

    private long ct;

    public Account(long ct)
    {
        this.ct = ct;
    }

    public long getCt()
    {
        return ct;
    }

    public synchronized void Einzahlen(long betrag)
    {
        ct += betrag;
    }

    public synchronized void Abheben(long betrag)
    {
        ct -= betrag;
    }

    @Override
    public String toString()
    {
        return "Account{" + "ct=" + ct + '}';
    }
    
    
}
