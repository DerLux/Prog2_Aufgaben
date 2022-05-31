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

    private Color textColor = Color.black;
    private Color buttonColor = Color.lightGray;
    private static final Color selected = new Color(0xDA48E0);
    private static final Color buttonBorder = new Color(0x19c5cf);

    JPanel text;
    ButtonGroup group;
    JPanel einstellungen;
    JPanel op;
    JPanel progOpt;
    JPanel panel;

    JTextField opxTF;
    JTextField opyTF;
    JTextField resTF;

    JLabel opxLbl;
    JLabel opyLbl;
    JLabel resLbl;

    JRadioButton degRBtn = new JRadioButton("Deg", true);
    JRadioButton radRBtn = new JRadioButton("Rad");
    JCheckBox theme = new JCheckBox("Dark Mode", true);

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


    public Taschenrechner() {
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
        this.setOpacity(1.0f);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ein-/Ausgabe components
        opxLbl = new JLabel("Operand x");
        opyLbl = new JLabel("Operand y");
        resLbl = new JLabel("Ergebnis");
        opxTF = new JTextField(24);
        opxTF.setOpaque(true);
        opxTF.getDocument().addDocumentListener(calculate);
        opyTF = new JTextField(24);
        opyTF.setOpaque(true);
        opyTF.getDocument().addDocumentListener(calculate);
        resTF = new JTextField(24);
        resetResult();
        resTF.setOpaque(true);
        resTF.setEditable(false);

        // Ein-/Ausgabe Panel
        text = new JPanel(new GridLayout(3, 2));
        text.setOpaque(true);
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
        group = new ButtonGroup();
        group.add(degRBtn);
        group.add(radRBtn);

        // Einstellungen Panel
        einstellungen = new JPanel(new FlowLayout());
        einstellungen.setOpaque(true);
        einstellungen.add(degRBtn);
        degRBtn.addActionListener(this);
        degRBtn.setOpaque(true);
        einstellungen.add(radRBtn);
        radRBtn.addActionListener(this);
        radRBtn.setOpaque(true);
        einstellungen.add(theme);
        theme.addActionListener(this);
        theme.setOpaque(true);
        einstellungen.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //Operations Panel
        op = new JPanel(new GridLayout(2, 4));
        op.setOpaque(true);
        resetButtons();
        op.add(sumBtn);
        sumBtn.addActionListener(this);
        sumBtn.setBorder(BorderFactory.createLineBorder(selected, 2));
        //sumBtn.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        op.add(divBtn);
        divBtn.addActionListener(this);
        //divBtn.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        op.add(mulBtn);
        mulBtn.addActionListener(this);
        op.add(quotBtn);
        //mulBtn.setBorder(BorderFactory.createLineBorder(Color.black,0));

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
        progOpt = new JPanel(new FlowLayout());
        progOpt.setOpaque(true);
        progOpt.add(clearBtn);
        clearBtn.addActionListener(this);
        progOpt.add(pushMeBtn);
        pushMeBtn.addActionListener(this);
        progOpt.add(exitBtn);
        exitBtn.addActionListener(this);

        //panels zusammenbauen + padding
        panel = new JPanel();
        panel.setOpaque(true);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(text);
        panel.add(einstellungen);
        panel.add(op);
        panel.add(progOpt);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(panel);

        //zusammenbauen
        this.pack();
        //this.setResizable(false);
        this.setVisible(true);
        resetBorder();
        sumBtn.setBorder(BorderFactory.createLineBorder(selected, 2));
        darkMode(Color.YELLOW, Color.BLACK, Color.DARK_GRAY);

    }

    private void calculate() {
        //reset input background
        opxTF.setForeground(textColor);
        opyTF.setForeground(textColor);

        //replace , to .
        String x_str = opxTF.getText().replace(',', '.');
        String y_str = opyTF.getText().replace(',', '.');

        if (x_str.equals("") && y_str.equals("")) { //if both empty -> return
            resetResult();
            return;
        }

        if (!inputIsValid(x_str)) {
            opxTF.setForeground(Color.red);
            resTF.setText("Nene, soo nicht!");
            return;
        }

        if (!inputIsValid(y_str)) {
            opyTF.setForeground(Color.red);
            resTF.setText("Nene, so nicht!");
            return;
        }

        double x;
        double y;
        if (x_str.equals("")) x = 0.0;
        else x = Double.parseDouble(x_str);

        if (y_str.equals("")) y = 0.0;
        else y = Double.parseDouble(y_str);

        switch (operator) {
            case "+" -> resTF.setText(String.valueOf(x + y));
            case "-" -> resTF.setText(String.valueOf(x - y));
            case "*" -> resTF.setText(String.valueOf(x * y));
            case "/" -> {
                if (y == 0) { //Error, teilen durch 0 nicht möglich
                    if (y_str.equals("")) { //wenn y leer → wird wie 0 interpretiert
                        resTF.setText("gebe einen Wert für Y ein");
                    } else {
                        resTF.setText("durch 0 kann nicht geteilt werden");
                        opyTF.setForeground(Color.red);
                    }
                } else resTF.setText(String.valueOf(x / y));
            }
            case "sin" -> {
                if (x == 0) { //Error, sin von 0 nicht möglich
                    if (x_str.equals("")) { //wenn x leer → wird wie 0 interpretiert
                        resTF.setText("gebe einen Wert für X ein");
                    } else {
                        resTF.setText("Sin von 0 kann nicht berechnet werden");
                        opxTF.setForeground(Color.red);
                    }
                } else if (degRBtn.isSelected()) resTF.setText(String.valueOf(Math.sin(Math.toRadians(x))));
                else resTF.setText(String.valueOf(Math.sin(x)));
            }
            case "cos" -> {
                if (x == 0) { //Error, cos von 0 nicht möglich
                    if (x_str.equals("")) { //wenn x leer → wird wie 0 interpretiert
                        resTF.setText("gebe einen Wert für X ein");
                    } else {
                        resTF.setText("Cos von 0 kann nicht berechnet werden");
                        opxTF.setForeground(Color.red);
                    }
                } else if (degRBtn.isSelected()) resTF.setText(String.valueOf(Math.cos(Math.toRadians(x))));
                else {
                    resTF.setText(String.valueOf(Math.cos(x)));
                }
            }
            case "sqrt" -> {
                if (x == 0 && y < 0) { //Error, 0 ^ negative Zahl geht nicht
                    if (x_str.equals("")) { //wenn x leer → wird wie 0 interpretiert
                        resTF.setText("gebe einen Wert für X ein");
                    } else {
                        resTF.setText("0 hoch negative Zahl nicht erlaubt");
                        opyTF.setForeground(Color.red);
                    }
                } else resTF.setText(String.valueOf(Math.pow(x, y)));
            }
            case "log" -> {
                if (x <= 0) { //Error, x muss > 0 sein
                    if (x_str.equals("")) { //wenn x leer → wird wie 0 interpretiert
                        resTF.setText("gebe einen Wert für X ein");
                    } else {
                        resTF.setText("log muss positiv sein");
                        opxTF.setForeground(Color.red);
                    }
                } else resTF.setText(String.valueOf(Math.log(x)));
            }
        }
    }

    private boolean inputIsValid(String input) { //return true, if input is numeric or empty (accept , and .)
        return Pattern.matches("|(-*\\d+((,|.)\\d+)?)", input);
    }

    private void resetButtons() { //Buttons auf buttonColor + activate opyTF + result zurücksetzten
        opyTF.setEditable(true);
        sumBtn.setBackground(buttonColor);
        sumBtn.setForeground(textColor);
        divBtn.setBackground(buttonColor);
        divBtn.setForeground(textColor);
        mulBtn.setBackground(buttonColor);
        mulBtn.setForeground(textColor);
        quotBtn.setBackground(buttonColor);
        quotBtn.setForeground(textColor);
        sinBtn.setBackground(buttonColor);
        sinBtn.setForeground(textColor);
        cosBtn.setBackground(buttonColor);
        cosBtn.setForeground(textColor);
        sqrBtn.setBackground(buttonColor);
        sqrBtn.setForeground(textColor);
        logBtn.setBackground(buttonColor);
        logBtn.setForeground(textColor);
        calculate();
    }

    private void resetResult() {
        resTF.setText("Können wir jetzt endlich was rechnen?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == sumBtn) {
            operator = "+";
            resetButtons();
            resetBorder();
            sumBtn.setBorder(BorderFactory.createLineBorder(selected, 2));
        } else if (source == divBtn) {
            operator = "-";
            resetButtons();
            resetBorder();
            divBtn.setBorder(BorderFactory.createLineBorder(selected, 2));
        } else if (source == mulBtn) {
            operator = "*";
            resetButtons();
            resetBorder();
            mulBtn.setBorder(BorderFactory.createLineBorder(selected, 2));
        } else if (source == quotBtn) {
            operator = "/";
            resetButtons();
            resetBorder();
            quotBtn.setBorder(BorderFactory.createLineBorder(selected, 2));
        } else if (source == sinBtn) {
            operator = "sin";
            resetButtons();
            resetBorder();
            setYInputInactive();
            sinBtn.setBorder(BorderFactory.createLineBorder(selected, 2));
        } else if (source == cosBtn) {
            operator = "cos";
            resetButtons();
            resetBorder();
            setYInputInactive();
            cosBtn.setBorder(BorderFactory.createLineBorder(selected, 2));
        } else if (source == sqrBtn) {
            operator = "sqrt";
            resetButtons();
            resetBorder();
            sqrBtn.setBorder(BorderFactory.createLineBorder(selected, 2));
        } else if (source == logBtn) {
            operator = "log";
            resetButtons();
            resetBorder();
            setYInputInactive();
            logBtn.setBorder(BorderFactory.createLineBorder(selected, 2));
        } else if (source == degRBtn) {
            resetBorder();
            calculate();
        } else if (source == radRBtn) {
            resetBorder();
            calculate();
        } else if (source == clearBtn) {
            opxTF.setText("");
            opyTF.setText("");
            resetResult();
        } else if (source == pushMeBtn) {
            JOptionPane.showMessageDialog(myApp, "Hast du nichts besseres zu tun?");
        } else if (source == exitBtn) {
            System.exit(0);
        } else if (source == theme) {
            if (theme.isSelected()) {
                darkMode(Color.YELLOW, Color.BLACK, Color.DARK_GRAY);
            } else {
                darkMode(Color.BLACK, Color.WHITE, Color.LIGHT_GRAY);
            }
        }
    }

    private void darkMode(Color fore, Color back, Color button) {
        textColor = fore;
        buttonColor = button;
        resetButtons();
        resTF.setForeground(fore);

        this.getContentPane().setBackground(back);
        text.setBackground(back);
        einstellungen.setBackground(back);
        op.setBackground(back);
        progOpt.setBackground(back);
        opxTF.setBackground(back);
        //opxTF.setForeground(fore);
        opyTF.setBackground(back);
        resTF.setBackground(back);
        theme.setBackground(back);
        theme.setForeground(fore);
        radRBtn.setBackground(back);
        radRBtn.setForeground(fore);
        degRBtn.setBackground(back);
        degRBtn.setForeground(fore);
        opxLbl.setForeground(fore);
        opyLbl.setForeground(fore);
        resLbl.setForeground(fore);
        clearBtn.setBackground(button);
        clearBtn.setForeground(fore);
        exitBtn.setBackground(button);
        exitBtn.setForeground(fore);
        pushMeBtn.setBackground(button);
        pushMeBtn.setForeground(fore);
    }

    private void resetBorder() {
        sumBtn.setBorder(BorderFactory.createLineBorder(buttonBorder, 1));
        divBtn.setBorder(BorderFactory.createLineBorder(buttonBorder, 1));
        mulBtn.setBorder(BorderFactory.createLineBorder(buttonBorder, 1));
        quotBtn.setBorder(BorderFactory.createLineBorder(buttonBorder, 1));
        sinBtn.setBorder(BorderFactory.createLineBorder(buttonBorder, 1));
        cosBtn.setBorder(BorderFactory.createLineBorder(buttonBorder, 1));
        sqrBtn.setBorder(BorderFactory.createLineBorder(buttonBorder, 1));
        logBtn.setBorder(BorderFactory.createLineBorder(buttonBorder, 1));
    }

    private void setYInputInactive() {
        opyTF.setEditable(false);
        opyTF.setText("");
    }

    public static void main(String[] args) {
        myApp = new Taschenrechner();
    }

}