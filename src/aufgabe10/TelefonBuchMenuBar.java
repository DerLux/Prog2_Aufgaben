package aufgabe10;

import javax.swing.*;
import java.io.*;
import java.awt.event.*;


public class TelefonBuchMenuBar
        extends JMenuBar implements ActionListener {

    private TelefonBuch telBuch;
    // ...
    private JMenuItem menuRead;
    private JMenuItem menuSave;
    private JMenuItem menuEnd;

    public TelefonBuchMenuBar(TelefonBuch tb) {
        telBuch = tb;
        // Menüleiste einbauen:
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("Datei");
        //telBuch.s
        //telBuch.setJMenuBar(menuBar);

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

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
    }
}

