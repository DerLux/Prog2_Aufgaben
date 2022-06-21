package aufgabe10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class TelefonBuchEinfuegenPanel
        extends JPanel implements ActionListener {

    private TelefonBuch telBuch;
    private JTextField nameTF;
    private JTextField extraTF;
    private JTextField numberTF;
    private JButton inputBTN;

    public TelefonBuchEinfuegenPanel(TelefonBuch tb) {
        telBuch = tb;
        
//		JPanel panel1 = new JPanel();
//        panel1.setLayout(new GridLayout(3, 1));
//		panel1.add(new JLabel("Name"));
//		panel1.add(new JLabel("Zusatz"));
//		panel1.add(new JLabel("TelefonNummer"));
//
//        JPanel panel2 = new JPanel();
//        panel2.setLayout(new GridLayout(3, 1));
//        tfEinfuegenName = new JTextField("", 20);
//        panel2.add(tfEinfuegenName);
//        tfEinfuegenZusatz = new JTextField("", 20);
//        panel2.add(tfEinfuegenZusatz);
//        tfEinfuegenTelNr = new JTextField("", 20);
//        panel2.add(tfEinfuegenTelNr);
//
//        Border border = BorderFactory.createTitledBorder("Einfügen");
//        this.setBorder(border);
//        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
//        this.add(panel1);
//        this.add(panel2);
//        buttonEinfuegen = new JButton("Einfügen");
//        this.add(buttonEinfuegen);
//        buttonEinfuegen.addActionListener(this);



        // Input Panels erstellen:
        JPanel inputLBPanel = new JPanel(new GridLayout(3, 1));
        JPanel inputTFPanel = new JPanel(new GridLayout(3, 1));
        JPanel inputBTPanel = new JPanel(new FlowLayout(FlowLayout.LEADING,5,2));

        // Input Labels erstellen:
        JLabel nameLB = new JLabel("Name:");
        JLabel extraLB = new JLabel("Zusatz:");
        JLabel numberLB = new JLabel("Telefonnummer:");

        // Input Textfelder erstellen:
        nameTF = new JTextField("", 20);
        extraTF = new JTextField("", 20);
        numberTF = new JTextField("", 20);

        // Input Button erstellen & Größe festlegen:
        inputBTN = new JButton("Einfügen");
        inputBTN.setPreferredSize(new Dimension(100, 25));
        inputBTN.addActionListener(this);

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
        this.add(inputBTPanel);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == inputBTN) {
            if(!telBuch.insert(nameTF.getText(),extraTF.getText(),numberTF.getText())) {
                JOptionPane.showMessageDialog(this, "Eintrag existiert bereits");
                return;
            }
            nameTF.setText("");
            extraTF.setText("");
            numberTF.setText("");
        }
    }
}
