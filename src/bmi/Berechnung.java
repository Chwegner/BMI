package bmi;

/**
 *
 * @author Chef
 */
public class Berechnung
{

    public double BMIWert(int groesse, int gewicht)
    {
        double bmi;
        double g = (double) groesse;

        g /= 100;
        System.out.println(g);
        bmi = Math.round(gewicht / (g * g));
        return bmi;
    }

    public String Einteilung(String sex, double bmi)
    {
        String kategorie;
        int geschlecht;

        // String Geschlecht zu Int //
        if (sex.equals("männlich"))
        {
            geschlecht = 1;
        }
        else
        {
            geschlecht = 2;
        }

        // BMI - Tabelle //
        if (bmi < 20 && geschlecht == 1 || bmi < 19 && geschlecht == 2)
        {
            kategorie = "Untergewicht";
        }
        else if (bmi >= 20 && bmi < 25 && geschlecht == 1 || bmi >= 19 && bmi < 24 && geschlecht == 2)
        {
            kategorie = "Normalgewicht";
        }
        else if (bmi >= 25 && bmi < 30 && geschlecht == 1 || bmi >= 24 && bmi < 30 && geschlecht == 2)
        {
            kategorie = "Übergewicht";
        }
        else if (bmi >= 30 && bmi < 35)
        {
            kategorie = "Starkes Übergewicht";
        }
        else if (bmi >= 35 && bmi < 40)
        {
            kategorie = "Adipositas Grad II";
        }
        else
        {
            kategorie = "Adipositas Grad III";
        }

        return kategorie;

    }

}
