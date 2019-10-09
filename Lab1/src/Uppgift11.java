public class Uppgift11 {
    public static void main(String[] args) {

        double pi = 1;
        for(int i = 0; i < 500; i++) {
            double nämnare = 3 + 2*i;
            if(i%2 == 0) {
                pi -= 1.0/nämnare;
            } else {
                pi += 1.0/nämnare;
            }
        }

        System.out.println("De 500 första termerna av Gottfried Leibniz formel för att beräkna pi gav: " + 4*pi);


        pi = 1;
        double term;
        int i = 0;
        do {
            double nämnare = 3 + 2*i;
            term = 1.0/nämnare;

            if(i%2 == 0) {
                pi -= term;
            } else {
                pi += term;
            }
            i++;
        } while(term >= 0.00001);

        System.out.println("Gottfried Leibniz formel för att beräkna pi gav: " + 4*pi + " efter " + i + " termer");
    }
}
