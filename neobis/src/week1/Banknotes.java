import java.io.IOException;
import java.util.Scanner;

public class Banknotes {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(num);
        int n100 = num / 100;
        num = num - n100 * 100;
        System.out.println(n100 + " nota(s) de R$ 100,00");
        int n50 = num / 50;
        num = num - n50 * 50;
        System.out.println(n50 + " nota(s) de R$ 50,00");
        int n20 = num / 20;
        num = num - n20 * 20;
        System.out.println(n20 + " nota(s) de R$ 20,00");
        int n10 = num / 10;
        num = num - n10 * 10;
        System.out.println(n10 + " nota(s) de R$ 10,00");
        int n5 = num / 5;
        num = num - n5 * 5;
        System.out.println(n5 + " nota(s) de R$ 5,00");
        int n2 = num / 2;
        num = num - n2 * 2;
        System.out.println(n2 + " nota(s) de R$ 2,00");
        int n1 = num / 1;
        num = num - n1 * 1;
        if (num != 0) {
            n1 = n1 + num;
        }
        System.out.println(n1 + " nota(s) de R$ 1,00");

    }

}