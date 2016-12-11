/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper6.exercise1.früherkennungsserver;

import Paper6.Exercise1.Früherkennungsserver.IFrüherkennung;
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
public class Paper6Exercise1FrüherkennungsServer {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		System.setProperty("java.security.policy", "client.policy");
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());

			try {

				IFrüherkennung früh = new FrüherkennungsService();
				Registry reg = LocateRegistry.createRegistry(1099);

				IFrüherkennung stub = (IFrüherkennung) UnicastRemoteObject.exportObject(früh, 1099);
				
				reg.bind("analyse", stub);
				
				System.out.println("running...");

			} catch (RemoteException ex) {
				Logger.getLogger(Paper6Exercise1FrüherkennungsServer.class.getName()).log(Level.SEVERE, null, ex);
			} catch (AlreadyBoundException ex) {
				Logger.getLogger(Paper6Exercise1FrüherkennungsServer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}
}
