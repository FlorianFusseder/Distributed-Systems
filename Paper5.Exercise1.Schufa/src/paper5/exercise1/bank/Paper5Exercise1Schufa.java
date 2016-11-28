/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise1.bank;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class Paper5Exercise1Schufa {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		try {
			ILiquidiyChecker check = new LiquidityChecker();
			ILiquidiyChecker stub = (ILiquidiyChecker) UnicastRemoteObject.exportObject(check, 0);

			Registry reg = LocateRegistry.createRegistry(1099);

			reg.bind("Check", stub);
			System.out.println("Started");

		} catch (RemoteException | AlreadyBoundException ex) {
			Logger.getLogger(Paper5Exercise1Schufa.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
