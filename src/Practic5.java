import java.util.ArrayList;
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

    System.out.println("Задача №4: ");
    System.out.println("\t16, 28: " + sumDigProd(16, 28));
    System.out.println("\t0: " + sumDigProd(0));
    System.out.println("\t1, 2, 3, 4, 5, 6: " + sumDigProd(1, 2, 3, 4, 5, 6));

    System.out.println("Задача №5: ");
    String[] solution41 = new String[]{"toe", "ocelot", "maniac"};
    String[] solution42 = new String[]{"many", "carriage", "emit", "apricot", "animal"};
    System.out.println("\t[toe, ocelot, maniac]: " + sameVowelGroup(solution41));
    System.out.println("\t[many, carriage, emit, apricot, animal]: " + sameVowelGroup(solution42));
    // System.out.println("\t: " + ());
    // System.out.println("Задача №(): " + ());
    
  }
  private String listToString(ArrayList<String> linkedList) {
    String value = "[ ";
    for(int i = 0; i < linkedList.size(); i+= 1) {
      value += (String) linkedList.get(i) + " ";
    }
    return value + "]";
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
  private int sumDigProd(int ... vals) {
    int result = 0;
    for (int i = 0; i < vals.length; i += 1) {
      result += vals[i];
    }
    while (String.valueOf(result).length() > 1) {
      int val = 1;
      for (int i = 0; i < String.valueOf(result).length(); i += 1) {
        val *= Character.getNumericValue(String.valueOf(result).charAt(i));
      }
      result = val;
    }
    return result;
  }
  private String getVowels(String val) {
    String vowels = "";
    for (int i = 0; i < val.length(); i += 1) {
      if ("AEIOUaeiou".contains(val.substring(i, i + 1))) {
        vowels += val.substring(i, i + 1);
      }
    }
    return vowels;
  }
  private String sameVowelGroup(String[] vals) {
    ArrayList<String> arrayList = new ArrayList<>();
    String vowels = getVowels(vals[0]);
    for (int i = 0; i < vals.length; i += 1) {
      String wordVowels = getVowels(vals[i]);
      if (vowels.equals(wordVowels)) {
        arrayList.add(vals[i]);
      }
    }
    return listToString(arrayList);
  }

}