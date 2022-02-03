/**
 * @author (Paul Szelag)
 * @version (1.0.0)
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class PasswortAendern extends Frame
{
    public int KontoN;
    public int PasswortN;
    public int Kontostand;
    public TextField tfNP;
    public TextField tfConf;
    public Main main;
    private FileWriter writer;
    private File file;

    public PasswortAendern()
    {
        super("Passwort ändern");
        setLayout(null);
        setBounds(400,100,300,400);

        Label lbAnz = new Label("neues Passwort wählen");
        lbAnz.setBounds(10,50,200,20);
        add(lbAnz);

        tfNP = new TextField();
        tfNP.setBounds(10,80,100,20);
        add(tfNP);

        Button btConfirm = new Button("Bestätigen");
        btConfirm.setBounds(10,110,100,20);
        btConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                reader();
                neuesPasswort();
                tfConf.setText("Passwort geändert");
            }
        });
        add(btConfirm);

        Button btMain = new Button("Home");
        btMain.setBounds(10,140,100,20);
        btMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                main = new Main();
                setVisible(false);
            }
        });
        add(btMain);

        tfConf = new TextField();
        tfConf.setBounds(10,200,100,20);
        add(tfConf);

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

    public void neuesPasswort() {
        PasswortN = Integer.parseInt(tfNP.getText());
        file = new File(KontoN + ".txt");
        try{
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