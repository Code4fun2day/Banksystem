
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;

/**
 * @author (your name)
 * @version (a version number or a date)
 */
public class neuesKonto extends Frame
{
    public Main main;
    public int KontoN;
    public int PasswortN;
    public File file;
    public  FileWriter writer;

    public TextField tfNKontoN;
    public TextField tfNPasswortN;
    public TextField tfError;

    public neuesKonto()
    {
        super("Neues Konto erstellen");
        setLayout(null);
        setBounds(400,100,300,400);

        Label lbNKontoN = new Label("Kontonummer:");
        lbNKontoN.setBounds(10,50,85,20);
        add(lbNKontoN);

        tfNKontoN = new TextField();
        tfNKontoN.setBounds(95,50,50,20);
        add(tfNKontoN);

        Label lbNPasswortN = new Label("Dein Passwort:");
        lbNPasswortN.setBounds(10,80,85,20);
        add(lbNPasswortN);

        tfNPasswortN = new TextField();
        tfNPasswortN.setBounds(95,80,50,20);
        add(tfNPasswortN);

        Button btRun = new Button("Bestätigen");
        btRun.setBounds(10,110,100,20);
        btRun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                Kontosuche();
            }
        });
        add(btRun);

        Button btZurück = new Button("Zurück");
        btZurück.setBounds(10,140,100,20);
        btZurück.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                main = new Main();
                setVisible(false);
            }
        });
        add(btZurück);

        tfError = new TextField();
        tfError.setBounds(10,180,200,20);
        add(tfError);

        setBackground(Color.orange);
        setVisible(true);
    }

    public void Kontosuche() {
        KontoN = Integer.parseInt(tfNKontoN.getText());
        PasswortN = Integer.parseInt(tfNPasswortN.getText());

        Scanner scan = null;
        try{
            scan = new Scanner (new File(KontoN + ".txt"));
            tfError.setText("Konto schon Vorhanden");
        } catch (FileNotFoundException e) {
            file = new File(KontoN + ".txt");
            try {
                writer = new FileWriter(file,true);
                writer.write(String.valueOf(PasswortN));
                writer.write(String.valueOf(" "));
                writer.write(String.valueOf("0"));
                writer.flush();
                writer.close();
                main = new Main();
                setVisible(false);
            } catch(IOException a) {
                a.printStackTrace();
            }
        }
    }
}
