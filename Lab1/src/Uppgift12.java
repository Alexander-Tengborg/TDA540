import java.util.Scanner;

public class Uppgift12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Skriv in ett år!");
            int y = scanner.nextInt();
            int n = y - 1900;
            int a = n % 19;
            int b = (7*a + 1) / 19;
            int m = (11*a + 4 - b) % 29;
            int q = n / 4;
            int w = (n + q + 31 - m) % 7;
            int d = 25 - m - w;

            int dag;
            String månad;

            if(d > 0) {
                dag = d;
                månad = "april";
            } else {
                dag = 31+d;
                månad = "mars";
            }

            String output = String.format("År %d var påskdagen den %d %s", y, dag, månad);
            System.out.println(output);
            System.out.println();
        }
    }
}
