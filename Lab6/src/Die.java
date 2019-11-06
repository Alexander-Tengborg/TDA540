public class Die {
    private static String[] sides = new String[] {"L", "C", "R", ".", ".", "."};
    private String lastRoll = null;

    String roll() {
        int randomNumber = (int)(Math.random() * 6);

        lastRoll = sides[randomNumber];

        return sides[randomNumber];
    }

    String getLastRoll() {
        return lastRoll;
    }

    @Override
    public String toString() {
        return lastRoll;
    }
}
