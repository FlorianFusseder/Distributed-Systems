/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paper6.Exercise1.Früherkennungsserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Florian
 */
public interface IFrüherkennung extends Remote{
	
	Bericht analysieren(IRoentgenbild roentgenbild) throws RemoteException;
	
	void analysieren(IRoentgenbild roentgenbild, IAufrufer event) throws RemoteException;
}
