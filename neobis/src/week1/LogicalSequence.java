import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class LogicalSequence {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxNumber = scanner.nextInt();
        int number = 1;
        while (number <= maxNumber) {
            for (int i = 0; i < n; i++) {
                if (number <= maxNumber) {
                    System.out.print(number + " ");
                }
                number++;
            }
            System.out.println();
        }
    }
}
