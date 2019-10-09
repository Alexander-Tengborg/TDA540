// Programmet läser in hur mycket en vara kostar per styck, hur många enheter av varan
// som köpts samt beräknar och skriver ut totala priset efter att 10 procents rabatt erhållits om
// totalpriset överstiger 1000 kr.

import javax.swing.*;

public class Pris2 {
    public static void main(String[] args) {
        String indata = JOptionPane.showInputDialog("Ange varans pris i kronor: ");
        double perStyck = Double.parseDouble(indata);

        indata = JOptionPane.showInputDialog("Ange antalet enheter av varan: ");
        int antal = Integer.parseInt(indata);

        double bruttoPris = antal * perStyck;
        double nettoPris = 0;
        double rabatt = 0;

        if (bruttoPris > 3000) {
            rabatt = 15;
            nettoPris = bruttoPris*0.85;
        }
        else if (bruttoPris > 1500) {
            rabatt = 10;
            nettoPris = bruttoPris * 0.9;
        }
        else if (bruttoPris > 750) {
            rabatt = 5;
            nettoPris = bruttoPris * 0.95;
        }

        JOptionPane.showMessageDialog(null, "Bruttopris: " + bruttoPris + " kronor.\n" + "Rabatt: " + rabatt + "%, " + (bruttoPris-nettoPris) + " kronor.\n" + "Nettopris: " + nettoPris + " kronor.\n");
    }
}
