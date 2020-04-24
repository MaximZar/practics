import java.util.Arrays;

public class Practic5 {
  public void Practic5() {
    
    System.out.println("Практическая работа №5:");
    
    int[] firstSolution = encrypt("Hi there!");
    System.out.println("Задача №1('Hi there!'): " + arrayToString(firstSolution) + " " + decrypt(firstSolution));
    
    System.out.println("Задача №2: ");
    System.out.println("\tпешка \tA6 \tA7: \t" + canMove("пешка", "A6", "A7"));
    System.out.println("\tконь \tC7 \tA6: \t" + canMove("конь", "C7", "A6"));
    System.out.println("\tслон \tA7 \tG2: \t" + canMove("слон", "A7", "G2"));
    System.out.println("\tладья \tA8 \tH8: \t" + canMove("ладья", "A8", "H8"));
    System.out.println("\tферзь \tF5 \tD4: \t" + canMove("ферзь", "F5", "D4"));
    System.out.println("\tкороль\tC4 \tD5: \t" + canMove("король", "C4", "D5"));

    System.out.println("Задача №3: ");
    System.out.println("\tbutl, beautiful: " + canComplete("butl", "beautiful"));
    System.out.println("\ttulb, beautiful: " + canComplete("tulb", "beautiful"));
    // System.out.println("Задача №(): " + ());
    
  }
  private int[] encrypt(String line) {
    int[] code = new int [line.length()];
    code[0] = (int)line.charAt(0);
    for (int i = 1; i < line.length(); i += 1) {
      code[i] = (int)line.charAt(i) - (int)line.charAt(i - 1);
    }
    return code;
  }
  private String decrypt(int[] code) {
    int ascii = code[0];
    String result = Character.toString((char) ascii);
    for (int i = 1; i < code.length; i += 1) {
      ascii += code[i];
      String element = Character.toString((char) ascii);
      result += element;
    }
    return result;
  }
  private String arrayToString(int[] array) {
    return Arrays.toString(array);
  }
  private boolean canMove(String figure, String position, String futurePosition) {
    int letter = "ABCDEFGH".indexOf(position.charAt(0)) + 1;
    int number = Character.getNumericValue(position.charAt(1)); 
    int fLetter = "ABCDEFGH".indexOf(futurePosition.charAt(0)) + 1;
    int fNumber = Character.getNumericValue(futurePosition.charAt(1)); 
    boolean horizontal;
    boolean vertical;
    boolean diagonal;
    boolean stop;
    // ^ - исключающее или 
    switch (figure) {
      case "пешка":
        horizontal = fLetter - letter == 0;
        vertical = fNumber - number == 1;
        stop = fNumber < 9;
        return horizontal && vertical && stop;
      case "конь":
        int first = Math.abs(fLetter - letter);
        int second = Math.abs(fNumber - number);
        diagonal = (first == 1 && second == 2) ^ (first == 2 && second == 1);
        stop = fLetter < 9 && fNumber < 9;
        return diagonal && stop;
      case "слон":
        diagonal = Math.abs(fLetter - letter) == Math.abs(fNumber - number);
        stop = fLetter < 9 && fNumber < 9;
        return diagonal && stop;
      case "ладья":
        horizontal = Math.abs(fLetter - letter) > 0;
        vertical = Math.abs(fNumber - number) > 0;
        stop = fLetter < 9 && fNumber < 9;
        return (horizontal ^ vertical) && stop;
      case "ферзь":
        diagonal = fLetter - letter == fNumber - number;
        horizontal = Math.abs(fLetter - letter) > 0;
        vertical = Math.abs(fNumber - number) > 0;
        stop = fLetter < 9 && fNumber < 9;
        return ((horizontal ^ vertical) || diagonal) && stop;
      case "король":
        diagonal = (Math.abs(fLetter - letter) == 1) && (Math.abs(fNumber - number) == 1);
        horizontal = Math.abs(fLetter - letter) == 1;
        vertical = Math.abs(fNumber - number) == 1;
        stop = fLetter < 9 && fNumber < 9;
        return ((horizontal && vertical) || diagonal) && stop;
    }
    return false;
  }
  private boolean canComplete(String preWord, String line) {
    for (int i = 0; i < line.length(); i += 1) {
      if (preWord.length() == 0) {
        return false;
      }
      if (preWord.substring(0, 1).equals(line.substring(i, i + 1))) {
        preWord = preWord.substring(1); 
      }
    }
    if (preWord.length() != 0) {
      return false;
    }
    return true;
  }
}