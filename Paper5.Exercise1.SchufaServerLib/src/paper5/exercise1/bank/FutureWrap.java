/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise1.bank;

import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class FutureWrap implements IFuture{

	private Future<Boolean> future;

	public FutureWrap(Future<Boolean> future) {
		this.future = future;
	}

	@Override
	public Boolean isDone() throws RemoteException {
		return this.future.isDone();
	}

	@Override
	public Boolean get() throws RemoteException {
		try {
			return this.future.get();
		} catch (InterruptedException | ExecutionException ex) {
			Logger.getLogger(FutureWrap.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public boolean isCancelled() throws RemoteException {
		return this.future.isCancelled();
	}
	
}
