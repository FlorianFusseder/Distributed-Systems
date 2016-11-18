/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise0.rmi.test;

import java.rmi.Remote;
import java.rmi.RemoteException;



/**
 *
 * @author Florian Fußeder
 */
public interface IHello extends Remote
{
    public String Hallo(String message) throws RemoteException;
}
