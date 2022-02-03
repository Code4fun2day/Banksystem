import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;

/**
 * @author Paul Szelag
 * @version 2.0.0
 */
public class Überweisen extends Frame
{
    //Instances
    public Main main;
    private FileWriter writer;
    private File file;
    private int zwischenlager;
    private int KontoN;
    private int PasswortN;
    private int KontoZ;
    private int PasswortZ;
    private int Kontostand;
    private int KontostandZ;
    //Dashboard
    private Label lbZielkonto;
    private TextField tfZielKonto;
    private Label lbWieviel;
    private TextField tfWieviel;
    private Button btBestaetigen;
    private Button btBack;

    public Überweisen()
    {
        super("Überweisen");
        setLayout(null);
        setBounds(400, 100, 300, 400);

        lbZielkonto = new Label("Zielkonto:");
        lbZielkonto.setBounds(10,50,100,20);
        add(lbZielkonto);

        tfZielKonto = new TextField();
        tfZielKonto.setBounds(120,50,50,20);
        add(tfZielKonto);

        lbWieviel = new Label("Welche Summe?");
        lbWieviel.setBounds(10,80,100,20);
        add(lbWieviel);

        tfWieviel = new TextField();
        tfWieviel.setBounds(120,80,50,20);
        add(tfWieviel);

        btBestaetigen = new Button("Bestätigen");
        btBestaetigen.setBounds(10,110,80,20);
        btBestaetigen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                reader();
                readerKonto();
                if(Kontostand + 1 > Integer.parseInt(tfWieviel.getText()) && Integer.parseInt(tfWieviel.getText()) > 0) {
                    zwischenlager = Integer.parseInt(tfWieviel.getText());
                    kontostaendeAendern();
                    writer();
                    zwischenlager = 0;
                }
            }
        });
        btBestaetigen.setBackground(Color.gray);
        add(btBestaetigen);

        btBack = new Button("Zurück");
        btBack.setBounds(10,140,80,20);
        btBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                main = new Main();
                setVisible(false);
            }
        });
        btBack.setBackground(Color.gray);
        add(btBack);

        setBackground(Color.orange);
        setVisible(true);
    }

    public void reader() {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("Konten.txt"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        if(scan.hasNext()) {
            KontoN = Integer.parseInt (scan.next());
        }
        if(scan.hasNext()) {
            PasswortN = Integer.parseInt(scan.next());
        }
    }

    public void readerKonto() {
        KontoZ = Integer.parseInt(tfZielKonto.getText());

        Scanner scanZ = null;
        try {
            scanZ = new Scanner(new File(KontoZ + ".txt"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        if(scanZ.hasNext()) {
            PasswortZ = Integer.parseInt(scanZ.next());
        }
        if(scanZ.hasNext()) {
            KontostandZ = Integer.parseInt(scanZ.next());
        }

        Scanner scanK = null;
        try {
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

    public void kontostaendeAendern() {
        Kontostand = Kontostand - zwischenlager;
        KontostandZ = KontostandZ + zwischenlager;
    }

    public void writer() {
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

        file = new File(KontoZ + ".txt");
        try {
            writer = new FileWriter(file,false);
            writer.write(String.valueOf(PasswortZ));
            writer.write(String.valueOf(" "));
            writer.write(String.valueOf(KontostandZ));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}