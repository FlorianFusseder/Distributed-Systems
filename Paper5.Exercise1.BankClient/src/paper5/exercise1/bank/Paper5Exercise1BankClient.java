/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise1.bank;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class Paper5Exercise1BankClient {

    public static void main(String[] args) {

        System.setProperty("java.security.policy", "client.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());

            Scanner sc = new Scanner(System.in);
            String temp;
            try {
                Registry reg = LocateRegistry.getRegistry(1099);
                IManager manager = (IManager) reg.lookup("Balance");

                System.out.println("gib ein:");
                while (!"exit".equals(temp = sc.nextLine())) {
                    String[] sp = temp.split(" ");

                    if (sp.length == 2) {
                        String accountID = sp[0];
                        int cents = Integer.parseInt(sp[1]);

                        if (cents > 0) {
                            manager.deposit(accountID, cents);
                        } else {
                            manager.withdraw(accountID, cents);
                        }
                    } else {
                        IAccount a = manager.getAccount(sp[0]);
                        IAccount b = manager.getAccount(sp[1]);
                        int cents = Integer.parseInt(sp[2]);

                        System.out.println(sp[2] + " ct: "
                                + manager.getAccount(sp[0]).toString() + " -> "
                                + manager.getAccount(sp[1]).toString());

                        Cheque c = new Cheque(a, b, cents);
                        manager.withdraw(c);
                    }
                }

            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(Paper5Exercise1BankClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
