import java.text.DecimalFormat;
import java.util.Scanner;

public class Uppgift8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Skriv in utg�ngshastigheten i m/s:");
        double hastighet = scanner.nextDouble();

        System.out.println("Skriv in kastvinkeln i grader:");
        double vinkel = scanner.nextDouble()*Math.PI/180; //L�ser in vinkeln i grader, och omvandlar till radianer


        double g = 9.82;
        String h�jd = df.format((hastighet*hastighet*Math.sin(vinkel)*Math.sin(vinkel))/(2*g));
        String l�ngd = df.format((hastighet*hastighet*Math.sin(2*vinkel))/g);

        System.out.println(String.format("Banh�jden �r %s meter, och kastl�ngden �r %s meter", h�jd, l�ngd));
    }
}
