package aufgabe10;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.awt.event.*;


public class TelefonBuchMenuBar
        extends JMenuBar implements ActionListener {

    private TelefonBuch telBuch;

    //private JFileChooser fc = new JFileChooser();

    private JMenuItem menuRead;
    private JMenuItem menuSave;
    private JMenuItem menuEnd;

    public TelefonBuchMenuBar(TelefonBuch tb) {
        telBuch = tb;
        // Menüleiste einbauen:
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("Datei");
        this.add(menuBar);

        // Menüleiste hinzufügen & Unterpunkte erstellen
        menuBar.add(menuFile);
        menuRead = new JMenuItem("Telefonbuch lesen");
        menuRead.addActionListener(this);
        menuSave = new JMenuItem("Telefonbuch speichern");
        menuSave.addActionListener(this);
        menuEnd = new JMenuItem("Telefonbuch beenden");
        menuEnd.addActionListener(this);

        // Menü-Unterpunkte hinzufügen:
        menuFile.add(menuRead);
        menuFile.add(menuSave);
        menuFile.add(menuEnd);
    }

    private JFileChooser fileChooser() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Jetzt sich dir mal eine Datei aus!!!","txt");
        chooser.setFileFilter(filter);
        return chooser;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == menuRead) {
            JFileChooser fc = fileChooser();
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                if(!file.getName().endsWith(".txt")) {
                    JOptionPane.showMessageDialog(this, "Hoppla, laden hat nicht geklappt. Es wurde keine gültige Datei ausgewählt.");
                    return;
                }
                telBuch.read(file);
            }

        } else if(source == menuSave) {
            JFileChooser fc = fileChooser();
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                if (!file.getName().endsWith(".txt")) {
                    JOptionPane.showMessageDialog(this, "Hoppla, speichern hat nicht geklappt. Es wurde keine gültige Datei ausgewählt.");
                    return;
                }
                telBuch.save(file);
            }
        } else if(source == menuEnd) {
            int n = JOptionPane.showConfirmDialog(
                    this,
                    "Ich bin dann ganz traurig :-(",
                    "Willst du mich wirklich schließen?",
                    JOptionPane.YES_NO_OPTION
            );
            if (n == JOptionPane.YES_OPTION)
                System.exit(0);
        }
    }
}

