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
public interface IFuture extends Remote{
	
	Boolean isDone() throws RemoteException;
	
	Boolean get() throws RemoteException;
	
	boolean isCancelled() throws RemoteException;
	
}
