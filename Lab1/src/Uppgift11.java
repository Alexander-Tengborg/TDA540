public class Uppgift11 {
    public static void main(String[] args) {

        double pi = 1;
        for(int i = 0; i < 500; i++) {
            double n�mnare = 3 + 2*i;
            if(i%2 == 0) {
                pi -= 1.0/n�mnare;
            } else {
                pi += 1.0/n�mnare;
            }
        }

        System.out.println("De 500 f�rsta termerna av Gottfried Leibniz formel f�r att ber�kna pi gav: " + 4*pi);


        pi = 1;
        double term;
        int i = 0;
        do {
            double n�mnare = 3 + 2*i;
            term = 1.0/n�mnare;

            if(i%2 == 0) {
                pi -= term;
            } else {
                pi += term;
            }
            i++;
        } while(term >= 0.00001);

        System.out.println("Gottfried Leibniz formel f�r att ber�kna pi gav: " + 4*pi + " efter " + i + " termer");
    }
}
