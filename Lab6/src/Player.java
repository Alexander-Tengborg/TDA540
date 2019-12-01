public class Player {
    private int chips = 3;
    private String name;

    Player(String name) {
        this.name = name;
    }

    int getNbRolls() {
        if(chips >= 3) return 3;
        else return chips;
    }

    public int getChips() {
        return chips;
    }

    void addChips(int amount) {
        chips += amount;
    }

    void removeChips(int amount) {
        chips -= amount;
    }

    @Override
    public String toString() {
        String string = name + " (" + chips +" chips)";
        return string;
    }
}