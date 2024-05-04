import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ColumnInArray {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char ch = scanner.next().charAt(0);

        double[][] M = new double[12][12];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                M[i][j] = scanner.nextDouble();
            }
        }
        double ans = 0;
        if (ch == 'S') {
            for (int i = 0; i < 12; i++) {
                ans += M[i][n];
            }
        } else if (ch == 'M') {
            for (int i = 0; i < 12; i++) {
                ans += M[i][n];
            }
            ans = ans / 12;
        }

        DecimalFormat df = new DecimalFormat("#.#");
        System.out.println(df.format(ans));
    }

}