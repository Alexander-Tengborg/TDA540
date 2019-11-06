import java.util.Scanner;

/**
 * This class is a skeleton. Don't change the overall
 * structure but just uncomment and add code where needed.
 */
public class CommandLineLCR {

  public static void main(String[] args) {
    // Use this as an test area when starting out
    // I.e. instantiate objects and test
    // Later just comment out (don't erase the test code!)


    // TODO: Uncomment this when you are done
    runCommandLineLCR();
  }

  // TODO: For each class you implement, add a method here to test it.
  // private static void testXXX() { ... }

  // TODO: Uncomment below when possible
  public static void runCommandLineLCR() {

    LCRGame lcr = buildLCRGame();
    System.out.println("LCR started");

    Scanner s = new Scanner(System.in);

    boolean done = false;
    while (!done && !lcr.hasWinner) {
      render(lcr);
      System.out.println("Current player is " + lcr.getCurrentPlayer());
      System.out.print("> ");
      String cmd = s.nextLine();
      switch (cmd) {
        case "r":
          lcr.playTurn();
          // TODO: Play one player's turn and render the game's state
          break;
        case "q":
          done = true;
          break;
        default:
          System.out.println("Enter 'r' to continue or 'q' to quit");
      }
    }


    if (lcr.hasWinner) {
      // Game is finished
      render(lcr);
      System.out.println("Game over! Winner is " + lcr.getWinner());
    } else {
      // Game was aborted
      System.out.println("Game aborted");
      render(lcr);
    }
  }


  private static LCRGame buildLCRGame() {
    String[] playerNames = new String[] {"Gunnar", "Leif", "Gudrun"};

    LCRGame lcrGame = new LCRGame(playerNames);

    return lcrGame;
  }



  private static void render(LCRGame lcr) {
    if(lcr.turn != 0) {
      for (Die d : lcr.getDice()) {
        System.out.print(d + "  ");
      }
      System.out.println();
    }

    System.out.print("Players: ");
    for (Player p : lcr.getPlayers()) {
      System.out.print(p + " ");
    }
    System.out.println();
  }

}
