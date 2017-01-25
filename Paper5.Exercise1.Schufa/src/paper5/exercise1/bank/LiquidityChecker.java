/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise1.bank;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 *
 * @author Florian
 */
public class LiquidityChecker implements ILiquidiyChecker {

	private ExecutorService exec;

	public LiquidityChecker() {
		this.exec = Executors.newScheduledThreadPool(16);
	}

	@Override
	public IFuture checkCheque(Cheque cheque) throws RemoteException {
		
		Future<Boolean> future = this.exec.submit(() -> {
			Thread.sleep(5000);
			Boolean b = cheque.getPayAccount().getBalance() > cheque.getPayment();
			System.out.println(b + " -> " + cheque.getPayAccount().toString() + " > " + 0);

			return b;
		});

		IFuture futureWrap = new FutureWrap(future);

		IFuture returnFuture = (IFuture) UnicastRemoteObject.exportObject(futureWrap, 0);
		return returnFuture;
	}
}
