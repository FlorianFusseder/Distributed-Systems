/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise1.bank;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class Paper5Exercise1Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            System.setProperty("java.security.policy", "client.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());

                Registry reg = LocateRegistry.getRegistry(1099);

                ILiquidiyChecker checker = (ILiquidiyChecker) reg.lookup("Check");

                IManager acc = new AccountManager(checker);
                IManager stub = (IManager) UnicastRemoteObject.exportObject(acc, 0);

                reg.bind("Balance", stub);

                System.out.println("Startet");
                new Thread(() -> {
                    while (true) {
                        try {
                            for (Entry<Cheque, Future<Boolean>> entry : checker.getPendingFutures().entrySet()) {
                                if (entry.getValue().isDone() && !entry.getValue().isCancelled()) {
                                    System.out.println(entry.getKey().toString() + " -> " + entry.getValue().get().toString());
                                    if (!entry.getValue().get()) {
                                        acc.reverseWithdraw(entry.getKey());
                                    }
                                    checker.getPendingFutures().remove(entry.getKey());
                                }
                            }
                        } catch (RemoteException | InterruptedException | ExecutionException ex) {
                            Logger.getLogger(Paper5Exercise1Bank.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }).start();
            }

        } catch (RemoteException | AlreadyBoundException | NotBoundException ex) {
            Logger.getLogger(Paper5Exercise1Bank.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
