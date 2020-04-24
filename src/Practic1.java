public class Practic1 {
    public Practic1() {
        System.out.println("Практическая работа №1:");
        System.out.println("Задача №1(-9, 45): " + remainder(-9, 45));
        System.out.println("Задача №2(7, 4): " + triArea(7, 4));
        System.out.println("Задача №3(2, 3, 5): " + animals(2, 3, 5));
        System.out.println("Задача №4(0.2, 50, 9): " + profitableGamble(0.2, 50, 9));
        System.out.println("Задача №5(24, 26, 2): " + operation(24, 26, 2));
        System.out.println("Задача №6('A'): " + ctoa('A'));
        System.out.println("Задача №7(7): " + addUpTo(7));
        System.out.println("Задача №8(8, 10): " + nextEdge(8, 10));
        int[] array = {3, 4, 5};
        System.out.println("Задача №9([3, 4, 5]): " + sumOfCubes(array));
        System.out.println("Задача №10(42, 5, 10): " + abcmath(42, 5, 10));
    }
    private int remainder(int x, int y) {
        return x % y;
    }
    private double triArea(double a, double b) {
        return 0.5 * a * b;
    }
    private int animals(int chickens, int cows, int pigs) {
        return chickens * 2 + cows * 4 + pigs * 4;
    }
    private boolean profitableGamble(double prob, double prize, double pay) {
        return prob * prize > pay;
    }
    private String operation(double N, double a, double b) {
        if (a + b == N) {
            return "sum";
        }
        if (a - b == N) {
            return "subtraction";
        }
        if (a * b == N) {
            return "multiply";
        }
        if (a / b == N) {
            return "division";
        }
        return "none";
    }
    private int ctoa(char character) {
        return (int) character;
    }
    private int addUpTo(int n) {
        if (n == 1) {
            return n;
        }
        return n + addUpTo(n - 1);
    }
    private int nextEdge(int a, int b) {
        return a + b - 1;
    }
    private int sumOfCubes(int[] array) {
        int sOc = 0;
        for (int i = 0; i < array.length; i += 1) {
            sOc += array[i] * array[i] * array[i];
        }
        return sOc;
    }
    private boolean abcmath(int a, int b, int c) {
        int sumA = 0;
        for (int i = 1; i < b; i += 1) {
            sumA += a;
        }
        return sumA % c == 0;
    }
}
