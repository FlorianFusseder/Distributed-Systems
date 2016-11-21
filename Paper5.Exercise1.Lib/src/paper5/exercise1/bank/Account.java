/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise1.bank;

/**
 *
 * @author Florian
 */
public class Account implements IAccount {

    private String iban;
    private int balance;
    private String name;

    public Account(String name, String iban) {
        this.name = name;
        this.balance = 0;
        this.iban = iban;
    }

    @Override
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    public void alterBalance(int balance) {
        this.balance += balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit(int cents) {
        this.alterBalance(cents);
    }

    public void withdraw(int cents) {
        if (cents > 0) {
            this.alterBalance(cents *= -1);
        } else {
            this.alterBalance(cents);
        }
    }

    @Override
    public String toString() {
        return "Account{" + "iban=" + iban + ", balance=" + balance + ", name=" + name + '}';
    }
}
