package bmi;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Chef
 */
public class BMI
{

    public static void main(String[] args)
    {
        // Grundgerüst //
        JFrame frame = new JFrame("BMI-Rechner (Einteilung nach DGE, 1992)");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        // Labels //   
        JLabel labelGroesse, labelGewicht, labelSex;

        labelGroesse = new JLabel("Deine Größe (in cm):");
        labelGroesse.setSize(200, 100);
        constraints.gridx = 1;
        constraints.gridy = 1;
        frame.add(labelGroesse, constraints);

        labelGewicht = new JLabel("Dein Gewicht (in kg):");
        labelGewicht.setSize(20, 100);
        constraints.gridx = 2;
        constraints.gridy = 1;
        frame.add(labelGewicht, constraints);

        labelSex = new JLabel("Dein Geschlecht:");
        labelSex.setSize(200, 100);
        constraints.gridx = 3;
        constraints.gridy = 1;
        frame.add(labelSex, constraints);

        // Textboxen //
        JTextField textGroesse, textGewicht;

        textGroesse = new JTextField(5);
        constraints.gridx = 1;
        constraints.gridy = 2;
        frame.add(textGroesse, constraints);

        textGewicht = new JTextField(5);
        constraints.gridx = 2;
        constraints.gridy = 2;
        frame.add(textGewicht, constraints);

        // ComboBox Geschlecht //
        String[] sexStrings =
        {
            "männlich", "weiblich"
        };

        JComboBox sexList = new JComboBox(sexStrings);
        sexList.setSelectedIndex(0);
        constraints.gridx = 3;
        constraints.gridy = 2;
        frame.add(sexList, constraints);

        // Button //
        JButton button = new JButton("Abschicken");
        constraints.gridx = 2;
        constraints.gridy = 3;
        frame.add(button, constraints);

        // Ausgabefeld //
        JTextArea tArea = new JTextArea(5, 30);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.gridheight = 4;
        constraints.fill = GridBagConstraints.BOTH;
        frame.add(tArea, constraints);

        // ActionListener //
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == button)
                {
                    int groesse = Integer.parseInt(textGroesse.getText());
                    int gewicht = Integer.parseInt(textGewicht.getText());
                    String sex = (String) sexList.getSelectedItem();

                    Berechnung berechnung = new Berechnung();
                    double bmi = berechnung.BMIWert(groesse, gewicht);
                    String kategorie = berechnung.Einteilung(sex, bmi);

                    // Ausgabe in Textarea //
                    tArea.setText("Du hast eine Größe von " + groesse + "cm und ein Gewicht von " + gewicht + "kg angegeben.\r\n");
                    tArea.append("Dein Geschlecht ist " + sex + ".\r\n\r\n");
                    tArea.append("Aus deinen Angaben wurde folgender BMI-Wert errechnet: " + bmi + "\r\n");
                    tArea.append("Anhand dieses Wertes gehörst du zur Kategorie: " + kategorie);
                }

            }
        });

        // Abschluss //
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
