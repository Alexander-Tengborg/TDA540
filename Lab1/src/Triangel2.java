// Programmet ber�knar hypotenusan av en r�tvinklig triangel
// vars b�da katetrar �r 3.0 respektive 4.0

import javax.swing.*;

public class Triangel2 {
    public static void main(String[] arg) {
        double kateter1, kateter2, hypotenusa;
        kateter1 = Integer.parseInt(JOptionPane.showInputDialog("Sida 1"));
        kateter2 = Integer.parseInt(JOptionPane.showInputDialog("Sida 2"));
        hypotenusa = Math.sqrt(Math.pow(kateter1, 2) + Math.pow(kateter2, 2));
        JOptionPane.showMessageDialog(null, "En r�tvinklig triangel mid sidorna " + kateter1 + " och " + kateter2 + " har hypotenusan 5.0");
    }
}
