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
    
    System.out.println("Задача №3: ");
    System.out.println("\trgb(0,0,0): \t" + validColor("rgb(0,0,0)"));
    System.out.println("\trgb(0,,0): \t" + validColor("rgb(0,,0)"));
    System.out.println("\trgb(255,256,255): \t" + validColor("rgb(255,256,255)"));
    System.out.println("\trgba(0,0,0,0.123456789): \t" + validColor("rgba(0,0,0,0.123456789)"));

    System.out.println("Задача №4: ");
    System.out.println("\thttps://edabit.com?a=1&b=2&a=2: " + stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
    System.out.println("\thttps://edabit.com?a=1&b=2&a=2, ['b']: " + stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[]{"b"}));
    System.out.println("\thttps://edabit.com, ['b']: " + stripUrlParams("https://edabit.com", new String[]{ "b" }));
    
    System.out.println("Задача №5: ");
    System.out.println("\tWhy You Will Probably Pay More for Your Christmas Tree This Year: " + getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year"));
    System.out.println("\tHey Parents, Surprise, Fruit Juice Is Not Fruit: " + getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit"));
    System.out.println("\tVisualizing Science: " + getHashTags("Visualizing Science"));
    
    System.out.println("Задача №6: ");
    System.out.println("\t4: \t" + ulam(4));
    System.out.println("\t9: \t" + ulam(9));
    System.out.println("\t206: \t" + ulam(206));

    // System.out.println("Задача №7: ");
    // System.out.println("\tabcabcbb: " + longestNonrepeatingSubstring("abcabcbb"));
    // System.out.println("\taaaaaa: " + longestNonrepeatingSubstring("aaaaaa"));
    // System.out.println("\tabcde: " + longestNonrepeatingSubstring("abcde"));
    // System.out.println("\tabcda: " + longestNonrepeatingSubstring("abcda"));

    System.out.println("Задача №8: ");
    System.out.println("\t2: " + convertToRoman(2));
    System.out.println("\t12: " + convertToRoman(12));
    System.out.println("\t16: " + convertToRoman(16));
    System.out.println("\t2765: " + convertToRoman(2765));
    System.out.println("\t3999: " + convertToRoman(3999));

    System.out.println("Задача №9: ");
    System.out.println("\t6 * 4 = 24: " + formula("6 * 4 = 24"));
    System.out.println("\t18 / 17 = 2: " + formula("18 / 17 = 2"));
    System.out.println("\t16 * 10 = 160 = 14 + 120: " + formula("16 * 10 = 160 = 14 + 120"));
    
    // System.out.println("\t: \t" + ());
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
  private boolean validColor(String color) {
    String format = color.substring(0, color.indexOf("("));
    String[] numbers = color.substring(color.indexOf("(") + 1, color.indexOf(")")).split(",");
    for (int i = 0; i < numbers.length; i += 1) {
      if (numbers[i].equals("")) return false;
    }
    boolean checkFirst = Integer.valueOf(numbers[0]) < 256 && Integer.valueOf(numbers[0]) >= 0;
    boolean checkSecond = Integer.valueOf(numbers[1]) < 256 && Integer.valueOf(numbers[1]) >= 0;
    boolean checkThirt = Integer.valueOf(numbers[2]) < 256 && Integer.valueOf(numbers[2]) >= 0;
    switch (format) {
      case "rgb":
        if (numbers.length != 3) return false;
        return checkFirst && checkSecond && checkThirt;
      case "rgba":
        if (numbers.length != 4) return false;
        boolean checkFour = Double.valueOf(numbers[3]) >= 0 && Double.valueOf(numbers[3]) < 256;
        return checkFirst && checkSecond && checkThirt && checkFour;
    }
    return false;
  }
  private String stripUrlParams(String site) {
    if (!site.contains("?")) return site;
    String[] resultArr = site.substring(site.indexOf("?") + 1).split("&");
    String result = "";
    for (int i = 0; i < resultArr.length; i += 1) {
      // проверяем на повтор
      for (int j = 0; j < i; j += 1) {
        String last = resultArr[j].substring(0, resultArr[j].indexOf("="));
        String now = resultArr[i].substring(0, resultArr[i].indexOf("="));
        if (now.equals(last)) {
          resultArr[j] = resultArr[i];
          resultArr[i] = "";
          break;
        }
      }
    }
    for (int i = 0; i < resultArr.length; i += 1) {
      if (!resultArr[i].equals("")) {
        result += resultArr[i] + "&";
      }
    }
    result = result.charAt(result.length() - 1) == '&' ? result.substring(0, result.length() - 1) : result;
    return site.substring(0, site.indexOf("?") + 1) + result;
  }
  private String stripUrlParams(String site, String[] paramsToStrip) {
    if (!site.contains("?")) return site;
    String[] resultArr = site.substring(site.indexOf("?") + 1).split("&");
    String result = "";
    for (int i = 0; i < resultArr.length; i += 1) {
      // удаляем
      for (int j = 0; j < paramsToStrip.length; j += 1) {
        if (resultArr[i].substring(0, resultArr[i].indexOf("=")).equals(paramsToStrip[j])) {
          resultArr[i] = "";
          break;
        }
      }
      // проверяем на повтор
      for (int j = 0; j < i; j += 1) {
        if (resultArr[i].equals("")) break;
        String last = resultArr[j].substring(0, resultArr[j].indexOf("="));
        String now = resultArr[i].substring(0, resultArr[i].indexOf("="));
        if (now.equals(last)) {
          resultArr[j] = resultArr[i];
          resultArr[i] = "";
          break;
        }
      }
    }
    for (int i = 0; i < resultArr.length; i += 1) {
      if (!resultArr[i].equals("")) {
        result += resultArr[i] + "&";
      }
    }
    result = result.charAt(result.length() - 1) == '&' ? result.substring(0, result.length() - 1) : result;
    return site.substring(0, site.indexOf("?") + 1) + result;
  }
  private String getHashTags(String line) {
    String[] all = line.split(" ");
    String[] hashTags = new String[]{"", "", ""};
    //удалям знаки препинания
    for (int i = 0; i < all.length; i += 1) {
      int split = findSplitter(all[i]);
      if (split != -1) {
        all[i] = all[i].substring(0, split) + all[i].substring(split + 1);
      }
      all[i] = all[i].toLowerCase();
      if (all[i].length() > hashTags[0].length()) {
        hashTags[2] = hashTags[1];
        hashTags[1] = hashTags[0];
        hashTags[0] = all[i];
        continue;
      }
      if (all[i].length() > hashTags[1].length()) {
        hashTags[2] = hashTags[1];
        hashTags[1] = all[i];
        continue;
      }
      if (all[i].length() > hashTags[2].length()) {
        hashTags[2] = all[i];
      }
    }
    String result = "[";
    for (int i = 0; i < 3; i += 1) {
      if (!hashTags[i].equals("")) {
        result += "\"#" + hashTags[i] + "\", ";
      }
    }
    result = result.substring(0, result.length() - 1) + "]";
    return result;
  }
  private int ulam(int n) {
    int[] seq = new int[n];
    seq[0] = 1;
    seq[1] = 2;
    int num = 3;
    for (int i = 2; i < n; i += 1) {
      int counter = 0;
      for (int j = 0; j < i; j += 1) {
        for (int k = j + 1; k < i; k += 1) {
          if (seq[j] + seq[k] == num) counter += 1;
        }
      }
      if (counter == 1) {
        seq[i] = num;
      } else {
        i -= 1;
      }
      num += 1;
    }
    return seq[n - 1];
  }
  // private String longestNonrepeatingSubstring(String line) {

  // }
  private String converter(String[] convert, int figure) {
    switch (figure) {
      case 4:
        return convert[0] + convert[1];
      case 5:
        return convert[1];
      case 9:
        return convert[0] + convert[2];
    }
    if (1 <= figure && figure <= 3) {
      return convert[0].repeat(figure);
    }
    if (6 <= figure && figure <= 8) {
      return convert[1] + convert[0].repeat(figure - 5);
    }
    return "";
  }
  private String convertToRoman(int numberArabic) {
    String result = "";
    String[][] convert = new String[][]{{"I", "V", "X"}, {"X", "L", "C"}, {"C", "D", "M"}};
    String number = String.valueOf(numberArabic);
    int index = 0;

    for (int i = number.length() - 1; i >= 0; i -= 1) {
      if (index > 2) {
          result = "M".repeat(Integer.valueOf(number.substring(i, i + 1))) + result;
          break;
      }
      result = converter(convert[index], Integer.valueOf(number.substring(i, i + 1))) + result;
      index += 1;
    }
    return result;
  }
  private double solution(String[] solution) {
    double num = Double.valueOf(solution[0]);
    for (int j = 1; j < solution.length; j += 1) {
      switch (solution[j]) {
        case "+":
          num += Double.valueOf(solution[j + 1]);
          break;
        case "-":
          num -= Double.valueOf(solution[j + 1]);
          break;
        case "*":
          num *= Double.valueOf(solution[j + 1]);
          break;
        case "/":
          num /= Double.valueOf(solution[j + 1]);
          break;
      }
      j += 1;
    }
    return num;
  }
  private boolean formula(String line) {
    String[] computation = line.split("=");
    double firstSolution = solution(computation[0].trim().split(" "));
    for (int i = 1; i < computation.length; i += 1) {
      double num = solution(computation[i].trim().split(" "));
      if (firstSolution != num){
        return false;
      }
    }
    return true;
  }
}