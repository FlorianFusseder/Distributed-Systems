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
public class Bank
{

    public static void main(String[] args)
    {
        Account acc = new Account(0);
        new Thread(new Abheber(acc)).start();
        new Thread(new Einzahler(acc)).start();
        new Thread(new Kontoauszug(acc)).start();
    }
}
