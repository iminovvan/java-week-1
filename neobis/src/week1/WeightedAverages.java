import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class WeightedAverages {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double s = 0.0;

        for(int i = 0; i < n; i++){
            s = 0.0;
            for(int j = 0; j < 3; j++ ){
                double num = scanner.nextDouble();
                if(j == 0){
                    num = num * 2.0;
                } else if(j == 1){
                    num = num * 3.0;
                } else{
                    num = num * 5.0;
                }
                s += num;
            }
            s = s / 10.0;
            DecimalFormat df = new DecimalFormat("0.0");
            System.out.println(df.format(s));
        }


    }

}