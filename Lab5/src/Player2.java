public class Player2 {
    String name;
    DiceCup diceCup;
    int totalSum = 0;

    Player2(String name, DiceCup diceCup) {
        this.name = name;
        this.diceCup = diceCup;
    }

    public String getName() {
        return name;
    }

    public int rollDice() {
        int sum = diceCup.rollAllDice();
        totalSum += sum;
        System.out.println(diceCup.toString());
        return sum;
    }

    public int totalResult() {
        return totalSum;
    }
}
