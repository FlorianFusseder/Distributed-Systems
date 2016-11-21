/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise1.bank;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Florian
 */
public class AccountManager implements IManager {

    Map<String, Account> accountMap;

    public AccountManager() {

        this.accountMap = new HashMap<>();

        Account a = new Account("Florian", "1");
        Account b = new Account("Sonja", "2");
        Account c = new Account("Floyd", "3");
        Account d = new Account("Sebastian", "4");

        this.accountMap.put(a.getIban(), a);
        this.accountMap.put(b.getIban(), b);
        this.accountMap.put(c.getIban(), c);
        this.accountMap.put(d.getIban(), d);

        this.accountMap.entrySet().forEach((entry) -> {
            System.out.println(entry.getValue().toString());
        });
    }

    @Override
    public Account getAccount(String iban) {
        return this.accountMap.get(iban);
    }

    @Override
    public void deposit(String iban, int cents) {
        this.alterBalance(iban, cents);
    }

    @Override
    public void withdraw(String iban, int cents) {
        this.alterBalance(iban, cents);
    }

    @Override
    public void withdraw(Cheque cheque) throws RemoteException {
        this.alterBalance(cheque.getPayAccount().getIban(), -cheque.getPayment());
        this.alterBalance(cheque.getTakeAccount().getIban(), cheque.getPayment());
    }

    public Map<String, Account> getAccountMap() {
        return Collections.unmodifiableMap(this.accountMap);
    }

    public void setAccountMap(Map<String, Account> accountMap) {
        this.accountMap = accountMap;
    }

    private void alterBalance(String iban, int cents) {
        Account acc = this.accountMap.get(iban);

        if (this.accountMap.containsKey(iban)) {
            System.out.print(acc.toString() +  " -> ");
            acc.alterBalance(cents);
            System.out.println(acc.toString());
        } else {
            throw new NullPointerException("Iban " + iban + " does not exist");
        }
    }
}
