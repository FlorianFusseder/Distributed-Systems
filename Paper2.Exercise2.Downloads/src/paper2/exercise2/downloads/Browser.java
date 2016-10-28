package paper2.exercise2.downloads;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Browser extends JFrame implements ActionListener
{

    private int downloads;
    private JProgressBar[] balken;
    private JButton startButton;

    // Deklaration Ihrer Synchronisations-Hilfsklassen hier:
    CountDownLatch startDownload;
    CountDownLatch doneDownload;

    public Browser(int downloads)
    {
        super("Mein Download-Browser");

            this.downloads = downloads;
            
            // Initialisierung Ihrer Synchronisations-Hilfsklassen hier:
            startDownload = new CountDownLatch(downloads);
            doneDownload = new CountDownLatch(downloads);
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
                new DownloadManager(startDownload, doneDownload, balken[i]).start();
                
            }
            
            startButton = new JButton("Downloads starten");
            startButton.addActionListener(this);
            
            this.add(zeilen, BorderLayout.CENTER);
            this.add(startButton, BorderLayout.SOUTH);
            
            pack();
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            this.actionPerformed(null);

    }

    public static void main(String[] args) throws InterruptedException
    {
        new Browser(5);
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            startDownload.countDown();
            
            startButton.setEnabled(false);
            startButton.setSelected(false);
            startButton.setText("Downloads laufen...");
            
            // Auf Ende aller Download-Threads warten ... erst dann die Beschriftung ändern
            // Achtung, damit die Oberflaeche "reaktiv" bleibt dies in einem eigenen Runnable ausfuehren!
            doneDownload.await();
            startButton.setEnabled(true);
            startButton.setSelected(true);
            startButton.setText("Downloads fertig");
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Browser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
