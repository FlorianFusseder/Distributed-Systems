/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper6.exercise1.Früherkennungsserver;

import Paper6.Exercise1.Früherkennungsserver.Bericht;
import java.rmi.RemoteException;
import Paper6.Exercise1.Früherkennungsserver.IAufrufer;

/**
 *
 * @author Florian
 */
public class Aufrufer implements IAufrufer {

	@Override
	public void isDone(Bericht b) throws RemoteException {
		System.out.println(b.toString());
	}
	
}
