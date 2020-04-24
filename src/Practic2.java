import java.util.Arrays;
import java.lang.String;

public class Practic2 {
    public Practic2() {
        System.out.println("Практическая работа №2:");

        System.out.println("Задача №1(\"hello\", 3): " + repeat("hello", 3));

        int[] array2 = {10, 4, 1, 4, -10, -50, 32, 21};
        System.out.println("Задача №2({10, 4, 1, 4, -10, -50, 32, 21}): " + differenceMaxMin(array2));

        int[] array3 = {1, 2, 3, 4};
        System.out.println("Задача №3({1, 2, 3, 4}): " + isAvgWhole(array3));

        int[] array4 = {3, 3, -2, 408, 3, 3};
        array4 = cumulativeSum(array4);
        String result = "[ ";
        for (int i = 0; i < array4.length; i += 1) {
            result += array4[i] + " ";
        }
        System.out.println("Задача №4([3, 3, -2, 408, 3, 3]): " + result + "]");

        System.out.println("Задача №5(43.20): " + getDecimalPlaces("43.20"));

        System.out.println("Задача №6(12): " + Fibonacci(12));

        System.out.println("Задача №7(39393): " + isValid("39393"));

        System.out.println("Задача №8(\"sparkling\", \"groups\"): " + isStrangePair("sparkling", "groups"));

        System.out.println("Задача №9Prefix(\"retrospect\", \"sub-\"): " + isPrefix("retrospect", "sub-"));
        System.out.println("Задача №9Suffix(\"arachnophobia\", \"-phobia\"): " + isSuffix("arachnophobia", "-phobia"));

        System.out.println("Задача №10(5): " + boxSeq(5));
    }
    private String repeat(String line, int n) {
        String result = "";
        for (int i = 0; i < line.length(); i += 1) {
            String plus = String.valueOf(line.charAt(i)).repeat(n);
            result += plus;
        }
        return result;
    }
    private int differenceMaxMin(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1] - array[0];
    }
    private boolean isAvgWhole(int[] array) {
        double avg = 0;
        for (int i = 0; i < array.length; i += 1) {
            avg += array[i];
        }
        avg /= array.length;
        return avg == Math.floor(avg);
    }
    private int[] cumulativeSum(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i += 1) {
            result[i] = 0;
        }
        for (int i = 0; i < array.length; i += 1) {
            for (int j = 0; j <= i; j += 1) {
                result[i] += array[j];
            }
        }
        return result;
    }
    private int getDecimalPlaces(String number) {
        int count = 0;
        if (!number.contains(".")) {
            return count;
        }
        for (int i = number.indexOf(".") + 1; i < number.length(); i += 1) {
            count += 1;
        }
        return count;
    }
    private int Fibonacci(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
    private boolean isValid(String number) {
        if (number.length() > 5 || number.length() < 5) {
            return false;
        }
        for (int i = 0; i < 5; i += 1) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    private boolean isStrangePair(String line1, String line2) {
        if (line1.length() < 1 && line2.length() < 1) {
            return true;
        }
        boolean firstProvision = line1.charAt(0) == line2.charAt(line2.length() - 1);
        boolean secondProvision = line1.charAt(line1.length() - 1) == line2.charAt(0);
        return firstProvision && secondProvision;
    }
    private boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.substring(0, prefix.length() - 1));

    }
    private boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.substring(1));
    }
    private int boxSeq(int count) {
        int step = 0;
        int stepCheck = 0;
        while (count > 0) {
            count -= 1;
            if (stepCheck == 0) {
                step += 3;
                stepCheck += 1;
            } else {
                step -= 1;
                stepCheck -= 1;
            }
        }
        return step;
    }
}
