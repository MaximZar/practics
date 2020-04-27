public class Practic6 {
  public Practic6() {
    System.out.println("Практическая работа №6:");

    System.out.println("Задача №1: ");
    System.out.println("\t1: \t" + bell(1));
    System.out.println("\t2: \t" + bell(2));
    System.out.println("\t3: \t" + bell(3));
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
}