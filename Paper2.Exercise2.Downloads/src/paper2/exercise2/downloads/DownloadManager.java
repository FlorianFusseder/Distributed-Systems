/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper2.exercise2.downloads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author Florian Fußeder
 */
class DownloadManager extends Thread
{

    private final CountDownLatch startDownload;
    private final CountDownLatch doneDownload;
    private final JProgressBar jProgressBar;
    
    DownloadManager(CountDownLatch startDownload, CountDownLatch doneDownload, JProgressBar jProgressBar)
    {
        this.startDownload = startDownload;
        this.doneDownload = doneDownload;
        this.jProgressBar = jProgressBar;
    }
        @Override
    public void run()
    {
        try
        {
            startDownload.await();
            while(jProgressBar.getValue() < jProgressBar.getMaximum()){
                sleep(new Random().nextInt(200)*10);
                jProgressBar.setValue(jProgressBar.getValue() + new Random().nextInt(10));
            }
            doneDownload.countDown();
            
        } catch (InterruptedException ex)
        {
            Logger.getLogger(DownloadManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString()
    {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
    
    
}
