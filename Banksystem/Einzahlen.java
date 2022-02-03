import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * @author Paul Szelag
 * @version 2.0.0
 */
public class Einzahlen extends Frame
{
    // instance variables - replace the example below with your own
    private FileWriter writer;
    private int zwischenlager;
    private File file;
    public int KontoN;
    public int PasswortN;
    public int Kontostand;
    //Klassen
    public Main main;
    
    //Dashboard
    private Label lbWieViel;
    private Label lbAS;
    private Button btFuenf;
    private Button btZehn;
    private Button btZwanzig;
    private Button btFuenfzig;
    private Button btHundert;
    private Button btZweihundert;
    private Button btAS;
    public TextField tfSumme;
    public Button btHome;

    /**
     * Constructor for objects of class Einzahlen
     */
    public Einzahlen()
    {
        super("Einzahlen");
        setLayout(null);
        setBounds(400,100,300,400);
        
        lbWieViel = new Label("Wie viel möchten sie einzahlen?");
        lbWieViel.setBounds(10,50,180,20);
        add(lbWieViel);
        
        btFuenf = new Button("5€");
        btFuenf.setBounds(10,100,40,20);
        btFuenf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                reader();
                readerKonto();
                zwischenlager = 5;
                writerKonto();
                zwischenlager = 0;
            }
        });
        btFuenf.setBackground(Color.green);
        add(btFuenf);
        
        btZehn = new Button("10€");
        btZehn.setBounds(100,100,40,20);
        btZehn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                reader();
                readerKonto();
                zwischenlager = 10;
                writerKonto();
                zwischenlager = 0;
            }
        });
        btZehn.setBackground(Color.red);
        add(btZehn);
        
        btZwanzig = new Button("20€");
        btZwanzig.setBounds(10,150,40,20);
        btZwanzig.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                reader();
                readerKonto();
                zwischenlager = 20;
                writerKonto();
                zwischenlager = 0;
            }
        });
        btZwanzig.setBackground(Color.cyan);
        add(btZwanzig);
        
        btFuenfzig = new Button("50€");
        btFuenfzig.setBounds(100,150,40,20);
        btFuenfzig.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                reader();
                readerKonto();
                zwischenlager = 50;
                writerKonto();
                zwischenlager = 0;
            }
        });
        btFuenfzig.setBackground(Color.orange);
        add(btFuenfzig);
        
        btHundert = new Button("100€");
        btHundert.setBounds(10,200,40,20);
        btHundert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                reader();
                readerKonto();
                zwischenlager = 100;
                writerKonto();
                zwischenlager = 0;
            }
        });
        btHundert.setBackground(Color.green);
        add(btHundert);
        
        btZweihundert = new Button("200€");
        btZweihundert.setBounds(100,200,40,20);
        btZweihundert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                reader();
                readerKonto();
                zwischenlager = 200;
                writerKonto();
                zwischenlager = 0;
            }
        });
        btZweihundert.setBackground(Color.yellow);
        add(btZweihundert);

        lbAS = new Label("Andere Summe:");
        lbAS.setBounds(10,240,140,20);
        add(lbAS);

        tfSumme = new TextField();
        tfSumme.setBounds(10,260,40,20);
        add(tfSumme);

        btAS = new Button("Bestätigen");
        btAS.setBounds(60,260,80,20);
        btAS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                reader();
                readerKonto();
                zwischenlager = Integer.parseInt(tfSumme.getText());
                writerKonto();
                zwischenlager = 0;
            }
        });
        btAS.setBackground(Color.gray);
        add(btAS);

        btHome = new Button("Home");
        btHome.setBounds(10, 300, 140, 20);
        btHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                main = new Main();
                setVisible(false);
            }
        });
        btHome.setBackground(Color.gray);
        add(btHome);
        
        setBackground(Color.orange);
        setVisible(true);
    }

    public void reader() {
        Scanner scan = null;
        try{
            scan = new Scanner(new File("Konten.txt"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        if(scan.hasNext()) {
            KontoN = Integer.parseInt(scan.next());
        }
        if(scan.hasNext()) {
            PasswortN = Integer.parseInt(scan.next());
        }
    }

    public void readerKonto() {
        Scanner scanK = null;
        try{
            scanK = new Scanner(new File(KontoN + ".txt"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        if(scanK.hasNext()) {
            PasswortN = Integer.parseInt(scanK.next());
        }
        if(scanK.hasNext()) {
            Kontostand = Integer.parseInt(scanK.next());
        }
    }

    public void writerKonto() {
        Kontostand = Kontostand + zwischenlager;

        file = new File(KontoN + ".txt");
        try {
            writer = new FileWriter(file,false);
            writer.write(String.valueOf(PasswortN));
            writer.write(String.valueOf(" "));
            writer.write(String.valueOf(Kontostand));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}