package aufgabe10;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TelefonBuchGUI extends JFrame implements ActionListener {
    public static final JFrame myTelefonBuch = new JFrame();

    private TelefonBuch telBuch;

    JTextField sNameTF;
    JTextField sExtraTF;

    JComboBox<String> searchBX;
    JButton use;

    JTextArea outputTA;

    public TelefonBuchGUI() {
        // TelefonBuch anlegen:
        telBuch = new TelefonBuch();

        // Search Panels erstellen:
        JPanel searchLBPanel = new JPanel(new GridLayout(2, 1));
        JPanel searchTFPanel = new JPanel(new GridLayout(2, 1));
        JPanel searchBTPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,3,2));
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEADING,5,2));

        // Search Labels erstellen:
        JLabel sNameLB = new JLabel("Name:");
        JLabel sExtraLB = new JLabel("Zusatz:");

        // Search Textfelder erstellen:
        sNameTF = new JTextField("", 16);
        sExtraTF = new JTextField("", 16);

        // Search Name hinzufügen:
        searchLBPanel.add(sNameLB);
        searchTFPanel.add(sNameTF);

        // Search Zusatz hinzufügen:
        searchLBPanel.add(sExtraLB);
        searchTFPanel.add(sExtraTF);

        // Search ComboBox erstellen & hinzufügen:
        searchBX = new JComboBox<>(new String[]{"Exakte Suche", "Präfix Suche", "Löschen"});
        use = new JButton("Anwenden");
        use.addActionListener(this);
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
        outputTA = new JTextArea();
        outputTA.setEditable(false);
        outputTA.setColumns(40);
        outputTA.setRows(10);
        outputPanel.add(outputTA);
        JScrollPane scroll = new JScrollPane (outputTA);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Output Umrahmung erstellen:
        outputPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
        outputPanel.setBorder(new TitledBorder("Ausgabe"));

        // MainPanel erstellen und konfigurieren:
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        //mainPanel.add(new TelefonBuchEinfuegenPanel(telBuch));
        this.setContentPane(mainPanel);

        // Hauptfenster zusammenbauen:
        this.setTitle("Telefonbuch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //mainPanel.add(new TelefonBuchMenuBar(telBuch));

        this.setJMenuBar(new TelefonBuchMenuBar(telBuch));
        mainPanel.add(new TelefonBuchEinfuegenPanel(telBuch));
        //mainPanel.add(new TelefonBuchSuchenLoeschenPanel(telBuch));
        this.add(searchPanel);
        this.add(outputPanel);
        this.add(scroll);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new TelefonBuchGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == use) {
            if(searchBX.getSelectedIndex() == 0) { //exakte suche
                String ergebnis = telBuch.exactSearch(sNameTF.getText(), sExtraTF.getText());
                if(ergebnis == null) {
                    JOptionPane.showMessageDialog(this, "Kein passender Eintrag gefunden");
                } else {
                    outputTA.setText(sNameTF.getText() + " " + sExtraTF.getText() + ":\t" + ergebnis);
                }
            } else if(searchBX.getSelectedIndex() == 1) { //präfix suche
                outputTA.setText("");
                var list = telBuch.prefixSearch(sNameTF.getText());
                for(var name:list)
                    outputTA.append(name + "\n");
            } else if(searchBX.getSelectedIndex() == 2) { //löschen
                if(telBuch.remove(sNameTF.getText(),sExtraTF.getText())) {
                    JOptionPane.showMessageDialog(this, "Eintrag gelöscht");
                } else {
                    JOptionPane.showMessageDialog(this, "Eintrag konnte nicht gelöscht werden");
                }
            }
            sNameTF.setText("");
            sExtraTF.setText("");
        }
    }
}
