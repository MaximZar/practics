import java.util.Scanner;
public class Practics {
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Какую практику вывести? ");
        int num = in.nextInt();
        switch (num) {
            case 1: 
                Practic1 pr1 = new Practic1();
                pr1.Practic1();
                break;
            case 2:
                Practic2 pr2 = new Practic2();
                pr2.Practic2();
                break;
            case 3:
                Practic3 pr3 = new Practic3();
                pr3.Practic3();
                break;
            case 4:
                Practic4 pr4 = new Practic4();
                pr4.Practic4();
                break;
            case 5:
                Practic5 pr5 = new Practic5();
                pr5.Practic5();
                break;
            default:
                System.out.println("Такой практики нет"); 
        }
    }
}
