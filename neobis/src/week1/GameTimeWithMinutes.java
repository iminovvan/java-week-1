import java.io.IOException;
import java.util.Scanner;

public class GameTimeWithMinutes {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int min = scanner.nextInt();
        int hourFinal = scanner.nextInt();
        int minFinal = scanner.nextInt();
        int hourDuration = 0, minDuration = 0;

        if (hour == hourFinal && min >= minFinal) {
            hourDuration = 24;
            if (min <= minFinal) {
                minDuration = minFinal - min;
            } else {
                hourDuration--;
                minDuration = 60 - (min - minFinal);
            }
        } else if (hour <= hourFinal) {
            hourDuration = hourFinal - hour;
            if (min <= minFinal) {
                minDuration = minFinal - min;
            } else {
                hourDuration--;
                minDuration = 60 - (min - minFinal);
            }
        } else if (hour > hourFinal) {
            hourDuration = 24 - (hour - hourFinal);
            if (min <= minFinal) {
                minDuration = minFinal - min;
            } else {
                hourDuration--;
                minDuration = 60 - (min - minFinal);
            }
        }

        System.out.println("O JOGO DUROU " + hourDuration + " HORA(S) E " + minDuration + " MINUTO(S)");

    }

}
