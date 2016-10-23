/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.testing;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Florian Fußeder
 */
public class DSTesting
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ReentrantReadWriteLock l = new ReentrantReadWriteLock();
        Lock rl = new ReentrantLock();
    }

}
