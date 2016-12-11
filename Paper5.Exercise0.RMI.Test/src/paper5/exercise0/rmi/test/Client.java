/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise0.rmi.test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian Fußeder
 */
public class Client
{
    
    public static void main(String[] args)
    {
        try {
            System.out.println("Starting Client");
            
            Registry rmi = LocateRegistry.getRegistry();
            
            IHello HelloServer = (IHello) rmi.lookup("Hello_RMI");
            
            String s = HelloServer.Hallo("Hello World");
            
            System.out.println(s);
            
            System.out.println("End Client");
            
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
