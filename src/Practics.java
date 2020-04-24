import java.util.Scanner;
public class Practics {
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Какую практику вывести? ");
        int num = in.nextInt();
        switch (num) {
            case 1: 
                new Practic1();
                break;
            case 2:
                new Practic2();
                break;
            case 3:
                new Practic3();
                break;
            case 4:
                new Practic4();
                break;
            case 5:
                new Practic5();
                break;
            default:
                System.out.println("Такой практики нет"); 
        }
        in.close();
    }
}
