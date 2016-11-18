/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise0.rmi.test;

import java.rmi.RemoteException;

/**
 *
 * @author Florian Fußeder
 */
public class HelloImpl implements IHello
{

    @Override
    public String Hallo(String message) throws RemoteException
    {
        return "#" + message + "#";
    }
    
}
