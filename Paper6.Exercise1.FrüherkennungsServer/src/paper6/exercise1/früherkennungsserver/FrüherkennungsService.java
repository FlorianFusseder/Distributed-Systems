/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper6.exercise1.früherkennungsserver;

import Paper6.Exercise1.Früherkennungsserver.Bericht;
import Paper6.Exercise1.Früherkennungsserver.IAufrufer;
import Paper6.Exercise1.Früherkennungsserver.IFrüherkennung;
import Paper6.Exercise1.Früherkennungsserver.IRoentgenbild;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class FrüherkennungsService implements IFrüherkennung {

	public FrüherkennungsService() {
	}

	@Override
	public Bericht analysieren(IRoentgenbild roentgenbild) throws RemoteException {
		System.out.println("Analyzing -> " + roentgenbild.showPicture());
		Bericht b;

		try {
			Thread.sleep((long) new Random().nextInt(10000) + 5000);
		} catch (InterruptedException ex) {
			Logger.getLogger(FrüherkennungsService.class.getName()).log(Level.SEVERE, null, ex);
		}

		System.out.println("Bild vom " + roentgenbild.getDate() + " ausgewertet");

		if (new Random().nextInt() % 3 == 0) {
			System.out.println("Uppsi des schaut ja schlecht aus");
			b = new Bericht(new Date(), "Krank", "Notschlachtn");
		} else {
			System.out.println("Ned auffällig");
			b = new Bericht(new Date(), "Gsund", "Hoamgeh");
		}

		return b;
	}

	@Override
	public void analysieren(IRoentgenbild roentgenbild, IAufrufer event) throws RemoteException {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Bericht b = analysieren(roentgenbild);
					event.isDone(b);
				} catch (RemoteException ex) {
					Logger.getLogger(FrüherkennungsService.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}).start();

	}

}
