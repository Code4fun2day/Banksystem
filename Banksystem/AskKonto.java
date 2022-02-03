import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
/**
 * @author Paul Szelag
 * @version 2.0.0
 */
public class AskKonto extends Frame
{
    // instance variables - replace the example below with your own
    public String Weg;
    public Main main;
    public Einzahlen Einz;
    public Auszahlen Ausz;
    public Überweisen Uebe;
    public Kontostand Kont;
    public PasswortAendern PswAe;
    public PasswortAendern NPW;
    public int Konto;
    public int PasswortUBE;
    public int Passwort;
    private FileWriter writer;
    public File file;
    //Dashboard
    private Label lbKonto;
    public TextField tfKonto;
    private Label lbKennwort;
    public TextField tfKennwort;
    private Button btUeberpruefen;
    private Button btZurueck;

    /**
     * Constructor for objects of class AskKonto
     */
    public AskKonto()
    {
        super("Abfrage");
        setLayout(null);
        setBounds(400,100,300,400);
        
        lbKonto = new Label("Kontonummer:");
        lbKonto.setBounds(10,50,90,20);
        add(lbKonto);
        
        tfKonto = new TextField();
        tfKonto.setBounds(100,50,50,20);
        tfKonto.setBackground(Color.red);
        add(tfKonto);
        
        lbKennwort = new Label("Passwort:");
        lbKennwort.setBounds(10,80,60,20);
        add(lbKennwort);
        
        tfKennwort = new TextField();
        tfKennwort.setBounds(100,80,50,20);
        tfKennwort.setBackground(Color.red);
        add(tfKennwort);
        
        btUeberpruefen = new Button("Überprüfen");
        btUeberpruefen.setBounds(10,110,110,20);
        btUeberpruefen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                kontogebenFunktion();
            }
        });
        btUeberpruefen.setBackground(Color.gray);
        add(btUeberpruefen);
        
        btZurueck = new Button("Zurück");
        btZurueck.setBounds(10,140,110,20);
        btZurueck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main =  new Main();
                setVisible(false);
            }
        });
        btZurueck.setBackground(Color.gray);
        add(btZurueck);
        
        setBackground(Color.orange);
        setVisible(true);
    }
    
    public void kontogebenFunktion() {
        Passwort = Integer.parseInt(tfKennwort.getText());
        Konto = Integer.parseInt(tfKonto.getText());

        Scanner Scan = null;
        try {
            Scan = new Scanner (new File(Konto + ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(Scan.hasNext()) {
            PasswortUBE = Integer.parseInt(Scan.next());
        }
        if(Passwort == PasswortUBE) {
            if(Weg == "Einzahlen") {
                Einz = new Einzahlen();
                setVisible(false);
                writerKonto();
            }
            if(Weg == "Auszahlen") {
                Ausz = new Auszahlen();
                setVisible(false);
                writerKonto();
            }
            if(Weg == "Ueberweisen") {
                Uebe = new Überweisen();
                setVisible(false);
                writerKonto();
            }
            if(Weg == "Kontostand") {
                Kont = new Kontostand();
                setVisible(false);
                writerKonto();
            }
            if(Weg == "NeuesPasswort") {
                PswAe = new PasswortAendern();
                setVisible(false);
                writerKonto();
            }
            if(Weg == "neuesPasswort") {
                NPW = new PasswortAendern();
                setVisible(false);
                writerKonto();
            }
        }
    }

    public void writerKonto() {
        file = new File("Konten.txt");
        try {
            writer = new FileWriter(file,false);
            writer.write(String.valueOf(Konto));
            writer.write(String.valueOf(" "));
            writer.write(String.valueOf(Passwort));
            writer.flush();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}