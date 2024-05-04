import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class BanknotesAndCoins {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        //take integer part
        int numInt = (int)num;
        //take decimal part
        double numDec = num - numInt;
        System.out.println("NOTAS:");
        int n100 = numInt / 100;
        numInt = numInt - n100 * 100;
        System.out.println(n100 + " nota(s) de R$ 100.00");
        int n50 = numInt / 50;
        numInt = numInt - n50 * 50;
        System.out.println(n50 + " nota(s) de R$ 50.00");
        int n20 = numInt / 20;
        numInt = numInt - n20 * 20;
        System.out.println(n20 + " nota(s) de R$ 20.00");
        int n10 = numInt / 10;
        numInt = numInt - n10 * 10;
        System.out.println(n10 + " nota(s) de R$ 10.00");
        int n5 = numInt / 5;
        numInt = numInt - n5 * 5;
        System.out.println(n5 + " nota(s) de R$ 5.00");
        int n2 = numInt / 2;
        numInt = numInt - n2 * 2;
        System.out.println(n2 + " nota(s) de R$ 2.00");

        System.out.println("MOEDAS:");
        int n1 = numInt / 1;
        System.out.println(n1 + " moeda(s) de R$ 1.00");
        double m5 = numDec / 0.50;
        numDec = numDec - (int)m5 * 0.50;
        System.out.println((int)m5 + " moeda(s) de R$ 0.50");
        double m25 = numDec / 0.25;
        numDec = numDec - (int)m25 * 0.25;
        System.out.println((int)m25 + " moeda(s) de R$ 0.25");
        double m10 = numDec / 0.10;
        numDec = numDec - (int)m10 * 0.10;
        System.out.println((int)m10 + " moeda(s) de R$ 0.10");
        double m05 = numDec / 0.05;
        numDec = numDec - (int)m05 * 0.05;
        System.out.println((int)m05 + " moeda(s) de R$ 0.05");
        numDec = Math.round(numDec * 100.0) / 100.0;
        double m01 = numDec / 0.01;
        numDec = numDec - (int)m01 * 0.01;
        System.out.println((int)m01 + " moeda(s) de R$ 0.01");


    }

}