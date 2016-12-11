/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paper6.Exercise1.Früherkennungsserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author Florian
 */
public interface IRoentgenbild extends Remote {

	public byte[] showPicture() throws RemoteException;
	
	public void setDate(Date d) throws RemoteException;
	
	public Date getDate() throws RemoteException;
}
