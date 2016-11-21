/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise1.bank;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.concurrent.Future;

/**
 *
 * @author Florian
 */
public interface ILiquidiyChecker extends Remote {

    void checkCheque(Cheque cheque) throws RemoteException;

    Map<Cheque, Future<Boolean>> getPendingFutures() throws RemoteException;
}
