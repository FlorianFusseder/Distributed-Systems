/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper2.exercise2.downloads;

import static java.lang.Thread.sleep;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author Florian Fußeder
 */
class DownloadManagerLatch extends Thread
{

    private final CountDownLatch startDownload;
    private final CountDownLatch doneDownload;
    private final JProgressBar jProgressBar;

    DownloadManagerLatch(CountDownLatch startDownload, CountDownLatch doneDownload, JProgressBar jProgressBar, String Name)
    {
        this.startDownload = startDownload;
        this.doneDownload = doneDownload;
        this.jProgressBar = jProgressBar;
        this.setName(Name);
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println(this.getName() + " started");
            System.out.println(this.getName() + " waiting");
            startDownload.await();
            System.out.println(this.getName() + " Started working");

            while (jProgressBar.getValue() < jProgressBar.getMaximum())
            {
                try
                {
                    int temp = jProgressBar.getValue() + new Random().nextInt(10);
                    System.out.println("Add to " + getName() + ": " + jProgressBar.getValue() + "/" + jProgressBar.getMaximum());
                    final int val = (temp < jProgressBar.getMaximum()) ? temp : jProgressBar.getMaximum();
                    jProgressBar.setValue(val);
                    sleep(new Random().nextInt(50) * 10);
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(DownloadManagerLatch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            doneDownload.countDown();
        } catch (InterruptedException ex)
        {
            Logger.getLogger(DownloadManagerLatch.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
