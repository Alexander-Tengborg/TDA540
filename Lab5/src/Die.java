public class Die {
    private int amountOfSides;
    private int lastRoll;

    Die(int sides) {
        amountOfSides = sides;
    }

    int roll() {
        int randomNumber = 1 + (int)(Math.random() * (amountOfSides));
        lastRoll = randomNumber;
        return randomNumber;
    }

    @Override
    public String toString() {
        return "Die{result=" + lastRoll + "}";
    }
}
