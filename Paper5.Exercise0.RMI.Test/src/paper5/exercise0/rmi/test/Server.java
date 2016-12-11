/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise0.rmi.test;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian Fußeder
 */
public class Server
{
    public static void main(String[] args) {
        try {
            System.out.println("start Server");
            
            IHello hi = new HelloImpl();
            
            IHello stub = (IHello) UnicastRemoteObject.exportObject(hi, 0);
            
            Registry rmi = LocateRegistry.createRegistry(1099);
            
            rmi.bind("Hello_RMI", stub);
            
            System.out.println("End Server");
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
