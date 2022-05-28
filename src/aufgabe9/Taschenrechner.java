package aufgabe9;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.regex.Pattern;

public class Taschenrechner extends JFrame implements ActionListener {
    private static JFrame myApp;
    private String operator = "+";

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
    JButton pushMeBtn = new JButton("Drück mich");
    JButton exitBtn = new JButton("Exit");


    public Taschenrechner () {
        //Dokument Listener for calculate
        DocumentListener calculate = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculate();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculate();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //calculate();
            }
        };

        this.setTitle("Taschenrechner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ein-/Ausgabe components
        JLabel opxLbl = new JLabel("Operand x");
        JLabel opyLbl = new JLabel("Operand y");
        JLabel resLbl = new JLabel("Ergebnis");
        opxTF = new JTextField(24);
        opxTF.getDocument().addDocumentListener(calculate);
        opyTF = new JTextField(24);
        opyTF.getDocument().addDocumentListener(calculate);
        resTF = new JTextField(24);
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
        degRBtn.addActionListener(this);
        einstellungen.add(radRBtn);
        radRBtn.addActionListener(this);
        einstellungen.add(theme);
        einstellungen.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        //Operations Panel
        JPanel op = new JPanel(new GridLayout(2,4));
        resetButtons();
        op.add(sumBtn);
        sumBtn.addActionListener(this);
        sumBtn.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        sumBtn.setBackground(Color.GREEN);
        op.add(divBtn);
        divBtn.addActionListener(this);
        divBtn.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        op.add(mulBtn);
        mulBtn.addActionListener(this);
        op.add(quotBtn);
        mulBtn.setBorder(BorderFactory.createLineBorder(Color.black,5));
        quotBtn.addActionListener(this);
        op.add(sinBtn);
        sinBtn.addActionListener(this);
        op.add(cosBtn);
        cosBtn.addActionListener(this);
        op.add(sqrBtn);
        sqrBtn.addActionListener(this);
        op.add(logBtn);
        logBtn.addActionListener(this);
        //op.setBorder(BorderFactory.createLineBorder(Color.black));

        //Programm-Optionen Panel
        JPanel progOpt = new JPanel(new FlowLayout());
        progOpt.add(clearBtn);
        clearBtn.addActionListener(this);
        progOpt.add(pushMeBtn);
        pushMeBtn.addActionListener(this);
        progOpt.add(exitBtn);
        exitBtn.addActionListener(this);

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
        //this.setResizable(false);
        this.setVisible(true);
    }

    private void calculate() {
        //reset input background
        opxTF.setForeground(Color.black);
        opyTF.setForeground(Color.black);

        //replace , to .
        String x_str = opxTF.getText().replace(',', '.');
        String y_str = opyTF.getText().replace(',', '.');

        if (x_str.equals("") && y_str.equals("")) { //if both empty -> return
            resetResult();
            return;
        }

        if(!inputIsValid(x_str)) {
            opxTF.setForeground(Color.red);
            resTF.setText("Operator X ist ungültig");
            return;
        }

        if(!inputIsValid(y_str)) {
            opyTF.setForeground(Color.red);
            resTF.setText("Operator Y ist ungültig");
            return;
        }

        double x;
        double y;
        if(x_str.equals(""))
            x = 0.0;
        else
            x = Double.parseDouble(x_str);

        if(y_str.equals(""))
            y = 0.0;
        else
            y = Double.parseDouble(y_str);

        switch (operator) {
            case "+" -> resTF.setText(String.valueOf(x+y));
            case "-" -> resTF.setText(String.valueOf(x-y));
            case "*" -> resTF.setText(String.valueOf(x*y));
            case "/" -> {
                if(y == 0) { //Error, teilen durch 0 nicht möglich
                    if (y_str.equals("")) { //wenn y leer → wird wie 0 interpretiert
                        resTF.setText("gebe einen Wert für Y ein");
                    }
                    else {
                        resTF.setText("durch 0 kann nicht geteilt werden");
                        opyTF.setForeground(Color.red);
                    }
                } else
                    resTF.setText(String.valueOf(x/y));
            }
            case "sin" -> {
                if(x == 0) { //Error, sin von 0 nicht möglich
                    if (x_str.equals("")) { //wenn x leer → wird wie 0 interpretiert
                        resTF.setText("gebe einen Wert für X ein");
                    }
                    else {
                        resTF.setText("Sin von 0 kann nicht berechnet werden");
                        opxTF.setForeground(Color.red);
                    }
                } else
                    if(degRBtn.isSelected())
                        resTF.setText(String.valueOf(Math.sin(Math.toRadians(x))));
                    else
                        resTF.setText(String.valueOf(Math.sin(x)));
            }
            case "cos" -> {
                if(x == 0) { //Error, cos von 0 nicht möglich
                    if (x_str.equals("")) { //wenn x leer → wird wie 0 interpretiert
                        resTF.setText("gebe einen Wert für X ein");
                    }
                    else {
                        resTF.setText("Cos von 0 kann nicht berechnet werden");
                        opxTF.setForeground(Color.red);
                    }
                } else
                    if(degRBtn.isSelected())
                        resTF.setText(String.valueOf(Math.cos(Math.toRadians(x))));
                    else {
                        resTF.setText(String.valueOf(Math.cos(x)));
                    }
            }
            case "sqrt" -> {
                if(x==0 && y < 0){ //Error, 0 ^ negative Zahl geht nicht
                    if (x_str.equals("")) { //wenn x leer → wird wie 0 interpretiert
                        resTF.setText("gebe einen Wert für X ein");
                    } else {
                        resTF.setText("0 hoch negative Zahl nicht erlaubt");
                        opyTF.setForeground(Color.red);
                    }
                } else
                    resTF.setText(String.valueOf(Math.pow(x,y)));
            }
            case "log" -> {
                if(x <= 0){ //Error, x muss > 0 sein
                    if (x_str.equals("")) { //wenn x leer → wird wie 0 interpretiert
                        resTF.setText("gebe einen Wert für X ein");
                    } else {
                        resTF.setText("log muss positiv sein");
                        opxTF.setForeground(Color.red);
                    }
                } else
                resTF.setText(String.valueOf(Math.log(x)));
            }
        }
    }

    private boolean inputIsValid(String input) { //return true, if input is numeric or empty (accept , and .)
        return Pattern.matches("|(-*\\d+((,|.)\\d+)?)",input);
    }

    private void resetButtons() { //Buttons auf Cyan + activate opyTF + result zurücksetzten
        opyTF.setEditable(true);
        sumBtn.setBackground(Color.CYAN);
        divBtn.setBackground(Color.CYAN);
        mulBtn.setBackground(Color.CYAN);
        quotBtn.setBackground(Color.CYAN);
        sinBtn.setBackground(Color.CYAN);
        cosBtn.setBackground(Color.CYAN);
        sqrBtn.setBackground(Color.CYAN);
        logBtn.setBackground(Color.CYAN);
        calculate();
    }

    private void resetResult() {
        resTF.setText("Bitte gebe Werte ein");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == sumBtn) {
            operator = "+";
            resetButtons();
            sumBtn.setBackground(Color.GREEN);
        } else if (source == divBtn){
            operator = "-";
            resetButtons();
            divBtn.setBackground(Color.GREEN);
        } else if (source == mulBtn){
            operator = "*";
            resetButtons();
            mulBtn.setBackground(Color.GREEN);
        } else if (source == quotBtn){
            operator = "/";
            resetButtons();
            quotBtn.setBackground(Color.GREEN);
        } else if (source == sinBtn){
            operator = "sin";
            resetButtons();
            setYInputInactive();
            sinBtn.setBackground(Color.GREEN);
        } else if (source == cosBtn){
            operator = "cos";
            resetButtons();
            setYInputInactive();
            cosBtn.setBackground(Color.GREEN);
        } else if (source == sqrBtn){
            operator = "sqrt";
            resetButtons();
            sqrBtn.setBackground(Color.GREEN);
        } else if (source == logBtn){
            operator = "log";
            resetButtons();
            setYInputInactive();
            logBtn.setBackground(Color.GREEN);
        } else if(source == degRBtn) {
            calculate();
        } else if(source == radRBtn) {
            calculate();
        } else if(source == clearBtn) {
            opxTF.setText("");
            opyTF.setText("");
            resetResult();
        } else if(source == pushMeBtn) {
            JOptionPane.showMessageDialog(
                    myApp,
                    "Hast du nichts besseres zu tun?"
            );
        } else if(source == exitBtn) {
            System.exit(0);
        }
    }

    private void setYInputInactive() {
        opyTF.setEditable(false);
        opyTF.setText("");
    }

    public static void main(String[ ] args) {
        myApp = new Taschenrechner();
    }

}
