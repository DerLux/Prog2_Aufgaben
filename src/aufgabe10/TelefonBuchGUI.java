package aufgabe10;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TelefonBuchGUI extends JFrame {
    private static final JFrame myTelefonBuch = new JFrame();

    private TelefonBuch telBuch;

    public TelefonBuchGUI() {
        // TelefonBuch anlegen:
        telBuch = new TelefonBuch();

        // Menüleiste einbauen:
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("Datei");
        myTelefonBuch.setJMenuBar(menuBar);

        // Menüleiste hinzufügen & Unterpunkte erstellen
        menuBar.add(menuFile);
        JMenuItem menuRead = new JMenuItem("Telefonbuch lesen");
        JMenuItem menuSave = new JMenuItem("Telefonbuch speichern");
        JMenuItem menuEnd = new JMenuItem("Telefonbuch beenden");

        // Menü-Unterpunkte hinzufügen:
        menuFile.add(menuRead);
        menuFile.add(menuSave);
        menuFile.add(menuEnd);

        // Input Panels erstellen:
        JPanel inputLBPanel = new JPanel(new GridLayout(3, 1));
        JPanel inputTFPanel = new JPanel(new GridLayout(3, 1));
        JPanel inputBTPanel = new JPanel(new FlowLayout());

        // Input Labels erstellen:
        JLabel nameLB = new JLabel("Name:");
        JLabel extraLB = new JLabel("Zusatz:");
        JLabel numberLB = new JLabel("Tel:");

        // Input Textfelder erstellen:
        JTextField nameTF = new JTextField("", 20);
        JTextField extraTF = new JTextField("", 20);
        JTextField numberTF = new JTextField("", 20);

        // Input Button erstellen & Größe festlegen:
        JButton inputBTN = new JButton("Einfügen");
        inputBTN.setPreferredSize(new Dimension(100, 25));

        // Input Labels hinzufügen:
        inputLBPanel.add(nameLB);
        inputLBPanel.add(extraLB);
        inputLBPanel.add(numberLB);

        // Input Textfelder hinzufügen:
        inputTFPanel.add(nameTF);
        inputTFPanel.add(extraTF);
        inputTFPanel.add(numberTF);

        // Input Buttons hinzufügen:
        inputBTPanel.add(inputLBPanel);
        inputBTPanel.add(inputTFPanel);
        inputBTPanel.add(inputBTN);

        // Input Umrahmung erstellen:
        inputBTPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
        inputBTPanel.setBorder(new TitledBorder("Einfügen"));

        // Search Panels erstellen:
        JPanel searchLBPanel = new JPanel(new GridLayout(2, 1));
        JPanel searchTFPanel = new JPanel(new GridLayout(2, 1));
        JPanel searchBTPanel = new JPanel(new GridLayout(2, 1));
        JPanel searchPanel = new JPanel(new FlowLayout());

        // Search Labels erstellen:
        JLabel sNameLB = new JLabel("Name:");
        JLabel sExtraLB = new JLabel("Zusatz:");

        // Search Textfelder erstellen:
        JTextField sNameTF = new JTextField("", 20);
        JTextField sExtraTF = new JTextField("", 20);

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

        // MainPanel erstellen und konfigurieren:
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        this.setContentPane(mainPanel);

        // Hauptfenster zusammenbauen:
        this.setTitle("Telefonbuch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(menuBar);
        this.setJMenuBar(menuBar);
        this.add(inputBTPanel);
        this.add(searchPanel);
        this.add(outputPanel);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new TelefonBuchGUI();
    }
}
