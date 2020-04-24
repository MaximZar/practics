public class Practic3 {
    public Practic3() {
        System.out.println("Практическая работа №3:");

        System.out.println("Задача №1(1, 0, 1): " + solution(1, 0, 1));
        System.out.println("Задача №2(\"all zip files are zipped\"): " + findZip("all zip files are zipped"));
        System.out.println("Задача №3(496): " + checkPerfect(496));
        System.out.println("Задача №4(\"Cat, dog, and mouse.\"): " + flipEndChars("Cat, dog, and mouse."));
        System.out.println("Задача №5(#CD5C5C): " + isValidHexCode("#CD5C5C"));
        int[] arr1 = {1, 3, 4, 4, 4};
        int[] arr2 = {2, 5, 7};
        System.out.println("Задача №6({1, 3, 4, 4, 4}, {2, 5, 7}): " + same(arr1, arr2));
        System.out.println("Задача №7(297): " + isKaprekar(297));
        System.out.println("Задача №8(100100100): " + longestZero("100100100"));
        System.out.println("Задача №9(24): " + nextPrime(24));
        System.out.println("Задача №10(145, 105, 100): " + rightTriangle(145, 105, 100));
    }
    private String solution(int a, int b, int c) {
        double d = b * b - 4 * a * c;
        if (d > 0) {
            return "has two solution";
        }
        if (d == 0) {
            return "has one solution";
        }
        return "has no solution";
    }
    private int findZip(String line) {
        if (!line.contains("zip")) {
            return -1;
        }
        int index = 0;
        int count = 0;
        for (int i = 0; i < line.length(); i += 1) {
            boolean checkZip = line.charAt(i) == 'z' && line.charAt(i + 1) == 'i' && line.charAt(i + 2) == 'p';
            if (checkZip) {
                count += 1;
                if (count == 2) {
                    index = i;
                    return index;
                }
            }
        }
        return -1;
    }
    private boolean checkPerfect(int number) {
        int sum = 0;
        int divMax = number / 2 + 1;
        for (int i = 1; i < divMax; i += 1) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
    private String flipEndChars(String line) {
        if (line.length() < 2) {
            return "Incompatible.";
        }
        char first = line.charAt(0);
        char last = line.charAt(line.length() - 1);
        String center = line.substring(1, line.length() - 1);
        if (first == last) {
            return "Two's a pair.";
        }
        return last + center + first;
    }
    private boolean isValidHexCode(String line) {
        if (line.charAt(0) != '#' || line.length() != 7) {
            return false;
        }
        String allow = "0123456789ABCDEFabcdef";
        for (int i = 1; i < line.length(); i += 1) {
            char symbol = line.charAt(i);
            if (!allow.contains(String.valueOf(symbol))) {
                return false;
            }
        }
        return true;
    }
    private boolean same(int[] arr1, int[] arr2) {
        String line1 = "";
        String line2 = "";
        for (int i = 0; i < arr1.length; i += 1) {
            if (!line1.contains(String.valueOf(arr1[i]))) {
                line1 += String.valueOf(arr1[i]);
            }
        }
        for (int i = 0; i < arr2.length; i += 1) {
            if (!line2.contains(String.valueOf(arr2[i]))) {
                line2 += String.valueOf(arr2[i]);
            }
        }
        return line1.length() == line2.length();
    }
    private boolean isKaprekar(int n) {
        if (n == 0 || n == 1) {
            return true;
        }
        String n2 = String.valueOf(n * n);
        int left;
        int right;
        int index = (int)Math.floor(n2.length() / 2);
        right = Integer.valueOf(n2.substring(index));
        if (n2.length() > 1) {
            left = Integer.valueOf(n2.substring(0, index));
        } else {
            left = 0;
        }
        return left + right == n;
    }
    private String longestZero(String line) {
        int count = 0;
        int max = 0;
        boolean check = false;
        for (int i = 0; i < line.length(); i += 1) {
            if (line.charAt(i) == '0') {
                check = true;
                count += 1;
                continue;
            }
            if (check) {
                max = Math.max(max, count);
                count = 0;
                check = false;
            }
        }
        return "0".repeat(max);
    }
    private int nextPrime(int number) {
        int prime = 0;
        for (int i = 2; i < number; i += 1) {
            if (number % i == 0) {
                prime = nextPrime(number + 1);
                break;
            }
            if (i == number - 1) {
                prime = number;
            }
        }
        return prime;
    }
    private boolean rightTriangle(int a, int b, int c) {
        boolean firstCase = a * a + b * b == c * c;
        boolean secondCase = a * a + c * c == b * b;
        boolean thirdCase = b * b + c * c == a * a;
        return firstCase || secondCase || thirdCase;
    }
}
