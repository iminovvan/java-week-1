import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class LogicalSequence {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println(i + " " + (int)Math.pow(i, 2) + " " + (int)Math.pow(i, 3));
            System.out.println(i + " " + (int)(Math.pow(i, 2)+1) + " " + (int)(Math.pow(i, 3)+1));
        }


    }

}