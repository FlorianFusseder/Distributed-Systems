/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise1.bank;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Florian
 */
public interface IManager extends Remote {

    public void deposit(String iban, int cents) throws RemoteException;

    public void withdraw(String iban, int cents) throws RemoteException;

    public void withdraw(Cheque cheque) throws RemoteException;
    
    public void reverseWithdraw(Cheque cheque) throws RemoteException;

    public IAccount getAccount(String iban) throws RemoteException;
}
