/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paper6.Exercise1.Früherkennungsserver;

import paper6.exercise1.Früherkennungsserver.Roentgenbild;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Scanner;
import paper6.exercise1.Früherkennungsserver.Aufrufer;

/**
 *
 * @author Florian
 */
public class Paper6Exercise1BarmherzigeBrueder {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		try {

			System.out.println("start bruder");
			Registry reg = LocateRegistry.getRegistry(1099);
			IFrüherkennung früh = (IFrüherkennung) reg.lookup("analyse");

			byte[] b = {1, 0};

			Scanner scan = new Scanner(System.in);
			System.out.print("Name: ");
			String name = scan.nextLine();

			do {
				IRoentgenbild r = new Roentgenbild(new Date(), name, b);
				IAufrufer c = new Aufrufer();
				IRoentgenbild ro = (IRoentgenbild) UnicastRemoteObject.exportObject(r, 0);
				IAufrufer ca = (IAufrufer) UnicastRemoteObject.exportObject(c, 0);

				früh.analysieren(ro, ca);
				System.out.println("");
				System.out.print("Name: ");
				name = scan.nextLine();

			} while (!name.equals("exit"));

		} catch (Exception ex) {

			System.out.println(ex.toString());
		}
	}

}
