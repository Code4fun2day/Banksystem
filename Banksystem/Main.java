import java.awt.*;
import java.awt.event.*;
//import java.awt.Color.*;

/**
 * @author Paul Szelag
 * @version 1.1.1
 */
public class Main extends Frame
{

    // instance variables - replace the example below with your own
    public AskKonto AskK;
    public neuesKonto NKon;
    
    //Dashboard
    private Button btKontostand;
    private Button btEinzahlen;
    private Label lbEinzahlen;
    private Button btAuszahlen;
    private Button btUeberweisen;
    private Button btNeuesKonto;
    private Button btNP;

    /**
     * Constructor for objects of class Main
     */
    public Main() {
        super("Funktion wählen");
        setLayout(null);
        setBounds(400,100,300,400);
        
        btEinzahlen = new Button("Einzahlen");
        btEinzahlen.setBounds(140,50,80,20);
        btEinzahlen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                AskK = new AskKonto();
                AskK.Weg = "Einzahlen";
                setVisible(false);
            }
        });
        btEinzahlen.setBackground(Color.gray);
        add(btEinzahlen);

        btAuszahlen = new Button("Abheben");
        btAuszahlen.setBounds(140,80,80,20);
        btAuszahlen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                AskK = new AskKonto();
                AskK.Weg = "Auszahlen";
                setVisible(false);
            }
        });
        btAuszahlen.setBackground(Color.gray);
        add(btAuszahlen);

        btUeberweisen = new Button("Überweisen");
        btUeberweisen.setBounds(140,110,80,20);
        btUeberweisen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                AskK = new AskKonto();
                AskK.Weg = "Ueberweisen";
                setVisible(false);
            }
        });
        btUeberweisen.setBackground(Color.gray);
        add(btUeberweisen);


        btKontostand = new Button("Kontostand");
        btKontostand.setBounds(140, 140, 80, 20);
        btKontostand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                AskK = new AskKonto();
                AskK.Weg = "Kontostand";
                setVisible(false);
            }
        });
        btKontostand.setBackground(Color.gray);
        add(btKontostand);

        btNeuesKonto = new Button("Neues Konto");
        btNeuesKonto.setBounds(140,170,110,20);
        btNeuesKonto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                NKon = new neuesKonto();
                setVisible(false);
            }
        });
        btNeuesKonto.setBackground(Color.gray);
        add(btNeuesKonto);

        btNP = new Button("Neues Passwort");
        btNP.setBounds(140,200,110,20);
        btNP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                AskK = new AskKonto();
                AskK.Weg = "neuesPasswort";
                setVisible(false);
            }
        });
        btNP.setBackground(Color.gray);
        add(btNP);
        
        lbEinzahlen = new Label("Klicken zum Aufrufen:");
        lbEinzahlen.setBounds(10,50,120,20);
        add(lbEinzahlen);

        setBackground(Color.orange);
        setVisible(true);
    }
}