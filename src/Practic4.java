public class Practic4 {
  public Practic4() {
    System.out.println("Практическая работа №4:");

    System.out.println("Задача №1(20, \"10,7 hello my name is Bessie and this is my essay➞\"): " + textProcess(20, "10,7 hello my name is Bessie and this is my essay➞"));
    System.out.println("Задача №2('((()))(())()()(()())'): " + split("((()))(())()()(()())"));
    System.out.println("Задача №3('is_modal_open' Snake -> Camel -> Snake): " + toCamelCase("is_modal_open") + " " + toSnakeCase("is_modal_open"));
    double[] money = {16, 18, 30, 1.8};
    System.out.println("Задача №4({16, 18, 30, 1.8}): " + overTime(money));
    System.out.println("Задача №5(205 pounds, 73 inches): " + BMI("205 pounds", "73 inches"));
    System.out.println("Задача №6(999): " + bugger(999));
    System.out.println("Задача №7(77777geff): " + toStarShorthand("77777geff"));
    System.out.println("Задача №8('Sam I am!', 'Green eggs and ham.'): " + doesRhyme("Sam I am!", "Green eggs and ham."));
    System.out.println("Задача №9(451999277, 411777299): " + trouble(451999277, 411777299));
    System.out.println("Задача №10('AZYWABBCATTTA', 'A'): " + countUniqueBooks("AZYWABBCATTTA", "A"));
  }
  private String textProcess(int k, String line) {
    String[] wordArray = line.split(" ");
    String result = "";
    int canUse = k;
    for (int i = 0; i < wordArray.length; i += 1) {
      if (canUse - wordArray[i].length() > 0) {
        result += wordArray[i] + " ";
        canUse -= (wordArray[i].length() + 1);
      } else {
        result += '\n' + wordArray[i] + " ";
        canUse = k - (wordArray[i].length() + 1);
      }
    }
    return result;
  } 
  private String split(String line) {
    int balance = 0;
    String chunk = "";
    String result = "";  
    for (int i = 0; i < line.length(); i += 1) {
      if (line.charAt(i) == '(') {
        balance += 1;
        chunk += "(";
        continue;
      }
      if (line.charAt(i) == ')') {
        chunk += ")";
        balance -= 1;
      }
      if (balance == 0) {
        result += chunk + ", ";
        chunk = "";
      }
    }
    return result;
  }
  private String toCamelCase(String line) {
    String[] wordArr = line.split("_");
    String result = wordArr[0];
    for (int i = 1; i < wordArr.length; i += 1) {
      result += wordArr[i].substring(0, 1).toUpperCase() + wordArr[i].substring(1).toLowerCase(); 
    }
    return result;
  }
  private String toSnakeCase(String line) {
    String result = line.substring(0, 1);
    for (int i = 1; i < line.length(); i += 1) {
      if (line.substring(i, i + 1) == line.substring(i, i + 1).toUpperCase()) {
        result += "_" + line.substring(i, i + 1).toLowerCase();
      } else {
        result += line.substring(i, i + 1);
      }
    }
    return result;
  }
  private String overTime(double[] money) {
    double regular = 0;
    double overReg = 0;
    if (money[0] < 17 && money[1] > 17) {
      regular = 17 - money[0];
      overReg = money[1] - 17;
    } 
    if (money[0] < 17 && money[1] < 17) {
      regular = money[1] - money[0];
      overReg = 0;
    }
    if (money[0] > 17) {
      regular = 0;
      overReg = money[1] - money[0];
    }
    String result = "$" + String.valueOf(regular * money[2] + overReg * money[2] * money[3]);
    return result;
  }
  private String BMI(String massa, String height) {
    double massaNum = Double.valueOf(massa.split(" ")[0]);
    double heightNum = Double.valueOf(height.split(" ")[0]);
    if (massa.endsWith("pounds")) {
      massaNum *= 0.453592;
    }
    if (height.endsWith("inches")) {
      heightNum *= 0.0254;
    }
    double bmi = Math.round((massaNum / (heightNum * heightNum)) * 10) / 10;
    String result = "";
    if (bmi < 18.5) {
      result = bmi + " Underweight";
    }
    if (bmi >= 18.5 && bmi < 25) {
      result = bmi + " Normal weight";
    }
    if (bmi >= 25) {
      result = bmi + " Overweight";
    }
    return result;
  }
  private int bugger(int number) {
    int num = number;
    if (Integer.toString(num).length() < 2) {
      return 0;
    }
    while (Integer.toString(num).length() > 1) {
      int period = 1;
      for (int i = 0; i < Integer.toString(num).length(); i += 1) {
        period *= Integer.valueOf(Integer.toString(num).substring(i, i + 1));
      }
      num = period;
    }
    return num;
  }
  private String toStarShorthand(String line) {
    String result = line.substring(0, 1);
    int n = 1;
    String last = result;
    for (int i = 1; i < line.length(); i += 1) {
      String now = line.substring(i, i + 1);
      if (now.equals(last)) {
        n += 1;
        if (i == line.length() - 1) {
          if (n > 1) {
            result += "*" + n;
          } else {
            result += now;
          }
        }
        continue;
      } 
      if (n > 1) {
        result += "*" + n;
      }
      result += now;
      n = 1;
      last = now;
    }
    return result;
  }
  private boolean doesRhyme(String line1, String line2) {
    String lastWord1 = line1.toLowerCase().substring(line1.lastIndexOf(" ") + 1);
    String lastWord2 = line2.toLowerCase().substring(line2.lastIndexOf(" ") + 1);
    String glas = "aiueoy";
    String glas1 = "";
    String glas2 = "";
    for (int i = 0; i < lastWord1.length(); i += 1) {
      if (glas.contains(lastWord1.substring(i, i + 1))) {
        glas1 += lastWord1.substring(i, i + 1);
      }
    }
    for (int i = 0; i < lastWord2.length(); i += 1) {
      if (glas.contains(lastWord2.substring(i, i + 1))) {
        glas2 += lastWord2.substring(i, i + 1);
      }
    }
    return glas1.equals(glas2);
  }
  private boolean trouble(long num1, long num2) {
    String numbers = "0123456789";
    for (int i = 0; i < numbers.length(); i += 1) {
      String repeat = numbers.substring(i, i + 1);
      String number1 = Long.toString(num1);
      String number2 = Long.toString(num2);
      boolean check = number1.contains(repeat.repeat(3)) && number2.contains(repeat.repeat(2));
      if (check) {
        return true;
      }
    }
    return false;
  }
  private int countUniqueBooks(String book, String uniq) {
    int count = 0;
    boolean bookStart = false;
    String books = "";
    for (int i = 0; i < book.length(); i += 1) {
      if (book.substring(i, i + 1).equals(uniq)) {
        bookStart = !bookStart;
        if (!bookStart) {
          books = "";
        }
        continue;
      }
      if (bookStart) {
        if (!books.contains(book.substring(i, i + 1))) {
          count += 1;
          books += book.substring(i, i + 1);
        }
      }
    }
    return count;
  }
}