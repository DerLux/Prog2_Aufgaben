package aufgabe10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.List;

public class TelefonBuchSuchenLoeschenPanel
        extends JPanel implements ActionListener {

    // ...

    public TelefonBuchSuchenLoeschenPanel(TelefonBuch tb) {
        // Search Panels erstellen:
        JPanel searchLBPanel = new JPanel(new GridLayout(2, 1));
        JPanel searchTFPanel = new JPanel(new GridLayout(2, 1));
        JPanel searchBTPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,3,2));
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEADING,5,2));

        // Search Labels erstellen:
        JLabel sNameLB = new JLabel("Name:");
        JLabel sExtraLB = new JLabel("Zusatz:");

        // Search Textfelder erstellen:
        JTextField sNameTF = new JTextField("", 16);
        JTextField sExtraTF = new JTextField("", 16);

        // Search Name hinzufügen:
        searchLBPanel.add(sNameLB);
        searchTFPanel.add(sNameTF);

        // Search Zusatz hinzufügen:
        searchLBPanel.add(sExtraLB);
        searchTFPanel.add(sExtraTF);

        // Search ComboBox erstellen & hinzufügen:
        JComboBox<String> searchBX = new JComboBox<>(new String[]{"Exakte Suche", "Präfix Suche", "Löschen"});
        JButton use = new JButton("Anwenden");
        searchBTPanel.add(searchBX);
        searchBTPanel.add(use);

        // Search Panels hinzufügen:
        searchPanel.add(searchLBPanel);
        searchPanel.add(searchTFPanel);
        searchPanel.add(searchBTPanel);

        // Search Umrahmung erstellen:
        searchPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
        searchPanel.setBorder(new TitledBorder("Suchen/Löschen"));

        // Output Panel erstellen:
        JPanel outputPanel = new JPanel();

        // Output TextArea konfigurieren:
        JTextArea outputTA = new JTextArea();
        outputTA.setEditable(false);
        outputTA.setColumns(40);
        outputTA.setRows(10);
        outputPanel.add(outputTA);

        // Output Umrahmung erstellen:
        outputPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
        outputPanel.setBorder(new TitledBorder("Ausgabe"));

        this.add(searchPanel);
        this.add(outputPanel);
    }

    public void actionPerformed(ActionEvent e) {
        // ...
    }
}
