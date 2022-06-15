package aufgabe10;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TelefonBuchGUI extends JFrame implements ActionListener {
    public static final JFrame myTelefonBuch = new JFrame();

    private TelefonBuch telBuch;

    private JFileChooser fc = new JFileChooser();



    private JMenuItem menuRead;
    private JMenuItem menuSave;
    private JMenuItem menuEnd;


    public TelefonBuchGUI() {
        // TelefonBuch anlegen:
        telBuch = new TelefonBuch();


        // Menüleiste einbauen:
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("Datei");
        myTelefonBuch.setJMenuBar(menuBar);

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

        this.add(menuBar);
        this.setJMenuBar(menuBar);
        //mainPanel.add(new TelefonBuchEinfuegenPanel(telBuch));
        //mainPanel.add(new TelefonBuchSuchenLoeschenPanel(telBuch));
        this.add(searchPanel);
        this.add(outputPanel);
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

        if (source == menuRead) {
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                System.out.println("Opening: " + file.getName() + ".\n");
                telBuch.read(file);
                //System.out.println(telBuch);
            } else {
                System.out.println("Open command cancelled by user.\n");
                //text.append("Open command cancelled by user.\n");
            }
            //text.setCaretPosition(text.getDocument().getLength());

        } else if(source == menuSave) {

        } else if(source == menuEnd) {

        }
    }
}
