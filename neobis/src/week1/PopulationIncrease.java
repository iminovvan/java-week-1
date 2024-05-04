import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class PopulationIncrease{

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pa, pb;
        double g1, g2;
        int time;
        for(int i = 0; i < n; i++){
            time = 0;
            pa = scanner.nextInt();
            pb = scanner.nextInt();
            g1 = scanner.nextDouble();
            g2 = scanner.nextDouble();
            while(pa <= pb){
                pa = pa + (int)(pa * g1 / 100);
                pb = pb + (int)(pb * g2 / 100);
                time++;
                if(time > 100){
                    System.out.println("Mais de 1 seculo.");
                    break;
                }
            }
            if(time <= 100){
                System.out.println(time + " anos.");
            }

        }

    }

}