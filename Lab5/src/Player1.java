public class Player1 {
    String name;
    Die die;

    Player1(String name, Die die) {
        this.name = name;
        this.die = die;
    }

    public String getName() {
        return name;
    }

    public int rollTheDie() {
        return die.roll();
    }
}
