import java.util.Arrays;
public class Practic5 {
  public void Practic5() {
    System.out.println("Практическая работа №5:");

    int[] firstSolution = encrypt("Hi there!");
    System.out.println("Задача №1('Hi there!'): " + arrayToString(firstSolution) + " " + decrypt(firstSolution));
    // System.out.println("Задача №2(): " + ());
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

}