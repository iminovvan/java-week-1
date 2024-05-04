import java.io.IOException;
import java.text.DecimalFormat;

public class SequenceIJ4 {

    public static void main(String[] args) throws IOException {
        double i = 0;
        for(int k = 0; k < 11; k++){
            double j = i + 1;
            for(int m = 0; m < 3; m++){
                DecimalFormat df = new DecimalFormat("#.#");
                System.out.println("I=" + df.format(i) + " J=" + df.format(j));
                j++;
            }
            i += 0.2;
        }
    }

}