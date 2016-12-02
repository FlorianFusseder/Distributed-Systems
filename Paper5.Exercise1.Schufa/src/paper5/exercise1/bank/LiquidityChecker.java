/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise1.bank;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 *
 * @author Florian
 */
public class LiquidityChecker implements ILiquidiyChecker {
    
	private Executor exec;

    public LiquidityChecker() {
        this.exec = new ScheduledThreadPoolExecutor(16);
    }

    @Override
    public IFuture checkCheque(Cheque cheque) throws RemoteException {

        FutureTask<Boolean> future = new FutureTask<>(
                () -> {
                    Thread.sleep(5000);
                    Boolean b = cheque.getPayAccount().getBalance() > cheque.getPayment();
                    System.out.println(b + " -> " + cheque.getPayAccount().toString() + " > " + 0);

                    return b;
                });
		
        exec.execute(future);
		IFuture futureWrap = new FutureWrap(future);
		
		IFuture returnFuture = (IFuture) UnicastRemoteObject.exportObject(futureWrap, 0);
		return returnFuture;
    }
}
