public class Practic6 {
  public Practic6() {
    System.out.println("Практическая работа №6:");

    System.out.println("Задача №1: ");
    System.out.println("\t1: \t" + bell(1));
    System.out.println("\t2: \t" + bell(2));
    System.out.println("\t3: \t" + bell(3));

    System.out.println("Задача №2: ");
    System.out.println("\tflag: \t" + translateWord("flag"));
    System.out.println("\tApple: \t" + translateWord("Apple"));
    System.out.println("\t'I like to eat honey waffles.': " + translateSentence("I like to eat honey waffles."));
    System.out.println("\t'Do you think it is going to rain today?': " + translateSentence("Do you think it is going to rain today?"));
  }
  private int bell(int n) {
    //решено с помощью треугольника Пирса
    int[] lastLine = new int[n];
    int[] activeLine = new int[n];
    lastLine[0] = 1; //проинцициализируем 1 строку
    int result;
    // i = 2 потому что первая строка уже есть
    for (int i = 2; i <= n; i += 1) {
      activeLine[0] = lastLine[i - 2]; // так как на прошлой итерации было бы i - 1
      for (int j = 1; j < i; j += 1) {
        activeLine[j] = lastLine[j - 1] + activeLine[j - 1];
      }
      lastLine = activeLine.clone();
    }
    result = lastLine[n - 1];
    return result;
  }
  private String translateWord(String line) {
    String vowels = "AEIOUaeiou";
    String translatedLetters = "";
    if (vowels.contains(line.substring(0, 1))) {
      return line + "yay";
    }
    for (int i = 0; i < line.length(); i += 1) {
      if (vowels.contains(line.substring(i, i + 1))) {
        translatedLetters = line.substring(i) + line.substring(0, i) + "ay";
        break;
      }
    }
    return translatedLetters;
  }
  private int findSplitter(String line) {
    String splitter = ".,?!\"':;<>\\|/";
    int index = -1;
    for (int i = 0; i < line.length(); i += 1) {
      if (splitter.contains(line.substring(i, i + 1))) {
        index = i;
      }
    }
    return index; 
  }
  private String translateSentence(String line) {
    String[] resultSentence = line.split(" ");
    for (int i = 0; i < resultSentence.length; i += 1) {
      int indexSplitter = findSplitter(resultSentence[i]);
      if (indexSplitter != -1) {
        String preWord = resultSentence[i].substring(0, indexSplitter);
        String postWord = resultSentence[i].substring(indexSplitter + 1);
        String splitter = resultSentence[i].substring(indexSplitter, indexSplitter + 1);
        resultSentence[i] = preWord.length() > 0 ? translateWord(preWord) : ""; 
        resultSentence[i] += splitter;
        resultSentence[i] += postWord.length() > 0 ? translateWord(postWord) : ""; 
      } else {
        resultSentence[i] = translateWord(resultSentence[i]);
      }
    }
    return String.join(" ", resultSentence);
  }
}