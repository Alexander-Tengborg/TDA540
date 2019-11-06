import java.util.Arrays;
import java.util.Scanner;

public class Lab5 {

  public static void main(String[] args) {

    // -- Part 1 --
    assert toRobber("java").equals("jojavova");
    assert toRobber("stubborn").equals("sostotubobboborornon");
    assert toRobber("Hej på dig").equals("Hohejoj popå dodigog");

    assert toPigLatin("pig").equals("igpay");
    assert toPigLatin("string").equals("ingstray");
    assert toPigLatin("omelet").equals("omeletay");
    assert toPigLatin("i").equals("iway");
    assert toPigLatin("Hej på dig").equals("Ejhay åpay igday");

    // uncomment this to test doCommandLine()
    //doCommandLine();

    // -- Part 2 --

    rollADie();
    letPlayerRoll();
    letTwoPlayersRollSameDice();
    letPlayerUseDiceCup();
    findPlayerWithMax();
  }

  // ---------- Del 1 ---------------

  // 1
  // Check if a given character is a vowel
  public static boolean isVowel(char ch) {
    String vowels = "aeiouyåäö";
    //TODO check uppercase???
    return vowels.contains(Character.toString(ch));
  }

  // Convert a string to Robber Speak
  public static String toRobber(String text) {
    String newText = new String();
    for(int i = 0; i < text.length(); i++) {
      char curChar = text.charAt(i);

      if(isVowel(curChar) || curChar == ' ') {
        newText += curChar;
      } else {
        newText += curChar + "o" + Character.toString(curChar).toLowerCase();
      }
    }
    return newText;
  }

  // 2
  // Convert a single word without spaces to Pig Latin
  // Precondition: text != null, text contains no spaces
  private static String wordToPigLatin(String text) {
    if(isVowel(text.charAt(0))) {
      if(!isVowel(text.charAt(text.length() - 1))) {
        text += "ay";
      } else if(isVowel(text.charAt(0)) && isVowel(text.charAt(text.length() - 1))) {
        text += "way";
      }
      return text;
    }

    boolean isCapitalLetter = Character.isUpperCase(text.charAt(0));
    text = text.toLowerCase();

    while(!isVowel(text.charAt(0))) {
      char firstChar = text.charAt(0);
      text = text.substring(1) + firstChar;
    }

    text += "ay";

    if(isCapitalLetter) {
      text = text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    return text;
  }

  // Convert a whole sentence to Pig Latin
  // Precondition: text != null
  public static String toPigLatin(String text) {
    String newText = new String();
    String[] splitText = text.split(" ");

    for(int i = 0; i < splitText.length; i++) {
      newText += wordToPigLatin(splitText[i]);
      if(i != splitText.length - 1) newText += " ";
    }

    return newText;
  }


  // 3
  // A command-line interface for the toRobber and toPigLatin methods
  public static void doCommandLine() {
    Scanner sc = new Scanner(System.in);

    boolean isRunning = true;

    while(isRunning) {
      System.out.println("Choose a translation method (r=robber, p=pig latin, or q=quit to quit)");

      String option = new String();
      if(sc.hasNext()) {
        option = sc.next();
        sc.nextLine();
      }

      String sentence = new String();

      switch(option) {
        case "r":
          System.out.println("Type a sentence to translate into Robber speak:");
          sentence = toRobber(sc.nextLine());
          break;

        case "p":
          System.out.println("Type a sentence to translate into Pig latin:");
          sentence = toPigLatin(sc.nextLine());
          break;

        case "q":
          isRunning = false;
          continue;

        default:
          continue;
      }

      System.out.println("Translation: " + sentence);
    }
  }


  // ---------- Del 2 ---------------

  // 4
  public static void rollADie() {
    printUppgift(4);
    Die die = new Die(6);

    for(int i = 0; i < 100; i++) {
      System.out.print(die.roll() + " ");
    }
    System.out.println();
  }

  // 5
  public static void letPlayerRoll() {
    printUppgift(5);
    String playerName = "Gurra";
    Die die = new Die(6);

    Player1 player = new Player1(playerName, die);

    System.out.println("The player is " + playerName);

    for(int i = 0; i < 5; i++) {
      System.out.print(player.rollTheDie() + " ");
    }
    System.out.println();
  }

  // 6
  public static void letTwoPlayersRollSameDice() {
    printUppgift(6);
    String[] playerNames = new String[] {"Boris", "Birgit"};

    Die die = new Die(6);

    for(int i = 0; i < playerNames.length; i++) {
      Player1 player = new Player1(playerNames[i], die);

      System.out.println("The player is " + playerNames[i]);

      for(int j = 0; j < 5; j++) {
        System.out.print(player.rollTheDie() + " ");
      }

      System.out.println();
    }

  }

  // 7 and 8    
  public static void letPlayerUseDiceCup() {
    printUppgift(7);
    DiceCup diceCup = new DiceCup();

    Player2 player = new Player2("Gunnar", diceCup);

    for(int i = 0; i < 2; i++) {
      player.rollDice();
      System.out.println(player.getName() + ": " + player.totalResult());
    }
  }

  // 9
  public static void findPlayerWithMax() {
    printUppgift(9);
    String[] playerNames = new String[] {"Bengt", "Ingvar", "Boalmar", "Leif", "Conny"};
    Player2 winner = null;

    for(int i = 0; i < playerNames.length; i++) {
      DiceCup diceCup = new DiceCup();

      Player2 player = new Player2(playerNames[i], diceCup);

      player.rollDice();
      System.out.println(player.getName() + ": " + player.totalResult());

      if(winner == null || player.totalResult() > winner.totalResult()) {
        winner = player;
      }
    }

    System.out.println(winner.getName() + " won with " + winner.totalResult() + " points");
  }

  public static void printUppgift(int uppgift) {
    System.out.println();
    System.out.println("Uppgift " + uppgift + ":");
  }
}
