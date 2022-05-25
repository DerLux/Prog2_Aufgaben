package aufgabe9;

import javax.swing.*;
import java.awt.*;

public class Taschenrechner extends JFrame {
    private char operator = '+';

    JTextField opxTF;
    JTextField opyTF;
    JTextField resTF;

    JRadioButton degRBtn = new JRadioButton("Deg", true);
    JRadioButton radRBtn = new JRadioButton("Rad");
    JCheckBox theme = new JCheckBox("Dark Mode", false);

    JButton sumBtn = new JButton("+");
    JButton divBtn = new JButton("-");
    JButton mulBtn = new JButton("*");
    JButton quotBtn = new JButton("/");
    JButton sinBtn = new JButton("sin");
    JButton cosBtn = new JButton("cos");
    JButton sqrBtn = new JButton("x^y");
    JButton logBtn = new JButton("log2");

    JButton clearBtn = new JButton("clear");
    JButton pushmeBtn = new JButton("Drück mich");
    JButton exitBtn = new JButton("Exit");


    public Taschenrechner () {
        this.setTitle("Taschenrechner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ein-/Ausgabe components
        JLabel opxLbl = new JLabel("Operand x");
        JLabel opyLbl = new JLabel("Operand y");
        JLabel resLbl = new JLabel("Ergebnis");
        opxTF = new JTextField(20);
        opyTF = new JTextField(20);
        resTF = new JTextField(20);
        resetResult();
        resTF.setEditable(false);

        // Ein-/Ausgabe Panel
        JPanel text = new JPanel(new GridLayout(3,2));
        text.add(opxLbl);
        text.add(opxTF);
        text.add(opyLbl);
        text.add(opyTF);
        text.add(resLbl);
        text.add(resTF);
        //text.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
        // BorderFactory.createLoweredBevelBorder()));
        //text.setBorder(BorderFactory.createLineBorder(Color.black));

        // Button Group Radio-Buttons
        ButtonGroup group = new ButtonGroup();
        group.add(degRBtn);
        group.add(radRBtn);

        // Einstellungen Panel
        JPanel einstellungen = new JPanel(new FlowLayout());
        einstellungen.add(degRBtn);
        einstellungen.add(radRBtn);
        einstellungen.add(theme);
        einstellungen.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        //Operations Panel
        JPanel op = new JPanel(new GridLayout(2,4));
        resetButtons();
        op.add(sumBtn);
        sumBtn.setBackground(Color.GREEN);
        op.add(divBtn);
        op.add(mulBtn);
        op.add(quotBtn);
        op.add(sinBtn);
        op.add(cosBtn);
        op.add(sqrBtn);
        op.add(logBtn);
        //op.setBorder(BorderFactory.createLineBorder(Color.black));

        //Programm-Optionen Panel
        JPanel progOpt = new JPanel(new FlowLayout());
        progOpt.add(clearBtn);
        progOpt.add(pushmeBtn);
        progOpt.add(exitBtn);

        //panels zusammenbauen + padding
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(text);
        panel.add(einstellungen);
        panel.add(op);
        panel.add(progOpt);
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        setContentPane(panel);

        //zusammenbauen
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    private void resetButtons() {
        sumBtn.setBackground(Color.CYAN);
        divBtn.setBackground(Color.CYAN);
        mulBtn.setBackground(Color.CYAN);
        quotBtn.setBackground(Color.CYAN);
        sinBtn.setBackground(Color.CYAN);
        cosBtn.setBackground(Color.CYAN);
        sqrBtn.setBackground(Color.CYAN);
        logBtn.setBackground(Color.CYAN);
    }

    private void resetResult() {
        resTF.setText("Bitte gebe Werte ein");
    }

    public static void main(String[ ] args) {
        JFrame myApp = new Taschenrechner();
    }
}