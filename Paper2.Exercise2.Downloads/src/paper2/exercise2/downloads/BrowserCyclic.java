package paper2.exercise2.downloads;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class BrowserCyclic extends JFrame implements ActionListener
{

    private int downloads;
    private JProgressBar[] balken;
    private JButton startButton;

    // Deklaration Ihrer Synchronisations-Hilfsklassen hier:
    CyclicBarrier startDownload;
    CyclicBarrier doneDownload;

    ArrayList<DownloadManagerLatch> dm = new ArrayList<>();

    public BrowserCyclic(int downloads)
    {
        super("Mein Download-Browser");

        this.downloads = downloads;
        // Initialisierung Ihrer Synchronisations-Hilfsklassen hier:
        startDownload = new CyclicBarrier(this.downloads + 1);
        doneDownload = new CyclicBarrier(downloads + 1);
        // Aufbau der GUI-Elemente:
        balken = new JProgressBar[downloads];
        JPanel zeilen = new JPanel(new GridLayout(downloads, 1));

        for (int i = 0; i < downloads; i++)
        {
            JPanel reihe = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 10));
            balken[i] = new JProgressBar(0, 100);
            balken[i].setPreferredSize(new Dimension(500, 20));
            reihe.add(balken[i]);
            zeilen.add(reihe);

            // neue Download-Threads erzeugen und starten
            // ggf. müssen Synchronisations-Objekte im Konstruktor übergeben werden!!
            // balken ist ebenfalls zu übergeben!
            new DownloadManagerCyclic(startDownload, doneDownload, balken[i], String.valueOf(i)).start();

        }

        startButton = new JButton("Downloads starten");
        startButton.addActionListener(this);

        this.add(zeilen, BorderLayout.CENTER);
        this.add(startButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws InterruptedException
    {
        new BrowserCyclic(5);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        new Thread(() ->
        {
            try
            {
                System.out.println(String.valueOf(startDownload.getNumberWaiting()) + " + 1 -> startet");
                startDownload.await();
            } catch (InterruptedException ex)
            {
                Logger.getLogger(BrowserCyclic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex)
            {
                Logger.getLogger(BrowserCyclic.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("go");

            try
            {
                startButton.setEnabled(false);
                startButton.setSelected(false);
                startButton.setText("Downloads laufen...");

                // Auf Ende aller Download-Threads warten ... erst dann die Beschriftung ändern
                // Achtung, damit die Oberflaeche "reaktiv" bleibt dies in einem eigenen Runnable ausfuehren!
                doneDownload.await();
                startButton.setText("Downloads starten");
                startDownload.reset();
                doneDownload.reset();
                startButton.setEnabled(true);
                for (int i = 0; i < downloads; i++)
                {
                    new DownloadManagerCyclic(startDownload, doneDownload, balken[i], String.valueOf(i)).start();
                }

            } catch (InterruptedException ex)
            {
                Logger.getLogger(BrowserCyclic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex)
            {
                Logger.getLogger(BrowserCyclic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
}
