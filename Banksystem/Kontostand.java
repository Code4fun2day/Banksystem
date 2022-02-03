import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/**
 * @author Paul Szelag
 * @version 0.0.1
*/

public class Kontostand extends Frame
{
    //Instances
    private int Kontostand;
    private int aktuellerKontostand;
    private int Konto;
    public Main main;
    //Dashboard
    private Label lbHead;
    private Label lbKontostand;
    private Button btBack;

    public Kontostand() {
        super("Kontostand");
        setLayout(null);
        setBounds(400, 100, 300, 400);

        reader();

        lbHead = new Label("Dein Kontostand Beträgt momentan:");
        lbHead.setBounds(10,50,210,20);
        add(lbHead);

        lbKontostand = new Label(String.valueOf(aktuellerKontostand));
        lbKontostand.setBounds(10,80,80,20);
        add(lbKontostand);

        btBack = new Button("Zurück");
        btBack.setBounds(10,110,80,20);
        btBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                main = new Main();
                setVisible(false);
            }
        });
        add(btBack);

        reset();

        setBackground(Color.orange);
        setVisible(true);
    }

    public void reader() {
        Scanner scanB = null;
        try {
            scanB = new Scanner(new File("Konten.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(scanB.hasNext()) {
            Konto = Integer.parseInt(scanB.next());
        }
        
        Scanner scan = null;
        try {
            scan = new Scanner(new File(Konto + ".txt"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        if(scan.hasNext()) {
            Kontostand = Integer.parseInt(scan.next());
            
        }
        if(scan.hasNext()) {
            Kontostand = Integer.parseInt(scan.next());
                aktuellerKontostand = Kontostand;
        }
        if(scan.hasNext()) {
            Kontostand = Integer.parseInt(scan.next());
            if(Konto == 3) {
                aktuellerKontostand = Kontostand;
            }
        }
        if(scan.hasNext()) {
            Kontostand = Integer.parseInt(scan.next());
            if(Konto == 4) {
                aktuellerKontostand = Kontostand;
            }
        }
        if(scan.hasNext()) {
            Kontostand = Integer.parseInt(scan.next());
            if(Konto == 5) {
                aktuellerKontostand = Kontostand;
            }
        }
        if(scan.hasNext()) {
            Kontostand = Integer.parseInt(scan.next());
            if(Konto == 6) {
                aktuellerKontostand = Kontostand;
            }
        }
        if(scan.hasNext()) {
            Kontostand = Integer.parseInt(scan.next());
            if(Konto == 7) {
                aktuellerKontostand = Kontostand;
            }
        }
        if(scan.hasNext()) {
            Kontostand = Integer.parseInt(scan.next());
            if(Konto == 8) {
                aktuellerKontostand = Kontostand;
            }
        }
        if(scan.hasNext()) {
            Kontostand = Integer.parseInt(scan.next());
            if(Konto == 9) {
                aktuellerKontostand = Kontostand;
            }
        }
    }

    public void reset() {
        Konto = 0;
        Kontostand = 0;
        aktuellerKontostand = 0;
    }
}