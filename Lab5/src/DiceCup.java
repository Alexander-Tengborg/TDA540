public class DiceCup {
    Die[] dice = new Die[5];

    DiceCup() {
        for(int i = 0; i < 5; i++) {
            dice[i] = new Die(6);
        }
    }

    public int rollAllDice() {
        int sum = 0;

        for(int i = 0; i < 5; i++) {
            sum += dice[i].roll();
        }

        return sum;
    }

    @Override
    public String toString() {
        String string = "DiceCup{dice=[";
        for(int i = 0; i < 5; i++) {
            string += dice[i].toString();
            if(i != 4) string += ", ";
        }
        string += "]}";

        return string;
    }
}
