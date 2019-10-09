import java.text.DecimalFormat;
import java.util.Scanner;

public class Uppgift8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Skriv in utgångshastigheten i m/s:");
        double hastighet = scanner.nextDouble();

        System.out.println("Skriv in kastvinkeln i grader:");
        double vinkel = scanner.nextDouble()*Math.PI/180; //Läser in vinkeln i grader, och omvandlar till radianer


        double g = 9.82;
        String höjd = df.format((hastighet*hastighet*Math.sin(vinkel)*Math.sin(vinkel))/(2*g));
        String längd = df.format((hastighet*hastighet*Math.sin(2*vinkel))/g);

        System.out.println(String.format("Banhöjden är %s meter, och kastlängden är %s meter", höjd, längd));
    }
}
