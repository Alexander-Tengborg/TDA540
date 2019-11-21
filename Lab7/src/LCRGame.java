public class LCRGame {
    Player[] players;
    Die[] dice;
    int currentPlayer = 0;
    int tablePot = 0; //needed???
    int turn = 0;

    boolean hasWinner = false;

    Player winner;

    LCRGame(String[] playerNames) {
        players = new Player[playerNames.length];

        for(int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }

    }

    void playTurn() {
        Player player = players[currentPlayer];

        int playerRolls = player.getNbRolls();

        dice = new Die[playerRolls];

        for(int i = 0; i < playerRolls; i++) {

            dice[i] = new Die();

            String result = dice[i].roll();

            switch(result) {
                case "L":
                    player.removeChips(1);
                    getPlayerLeft().addChips(1);
                    break;
                case "R":
                    player.removeChips(1);
                    getPlayerRight().addChips(1);
                    break;
                case "C":
                    player.removeChips(1);
                    tablePot++;
                    break;
                case ".":
                    break;
            }
        }

        if(player.getChips() == 0) checkWinner();

        nextPlayer();
        turn++;
    }

    Player getCurrentPlayer() {
        return players[currentPlayer];
    }

    void nextPlayer() {
        currentPlayer++;
        if(currentPlayer == players.length) currentPlayer = 0;
    }

    void checkWinner() {
        int playersWithoutChips = 0;

        Player winner = null;

        for(int i = 0; i < players.length; i++) {
            if(players[i].getChips() == 0) playersWithoutChips++;
            else winner = players[i];
        }

        if(players.length - playersWithoutChips == 1) {
            this.winner = winner;
            hasWinner = true;
        }
    }

    Player getPlayerRight() { // "fix" with ternary expression
        if(currentPlayer + 1 == players.length) {
            return players[0];
        } else {
            return players[currentPlayer + 1];
        }
    }

    Player getPlayerLeft() { // "fix" with ternary expression
        if(currentPlayer - 1 < 0) {
            return players[players.length - 1];
        } else {
            return players[currentPlayer - 1];
        }
    }

    Player[] getPlayers() {
        return players;
    }

    Die[] getDice() {
        return dice;
    }

    Player getWinner() {
        return winner;
    }
}