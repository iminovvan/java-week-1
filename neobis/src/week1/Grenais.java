import java.io.IOException;
import java.util.Scanner;

public class Grenais {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int interNum = scanner.nextInt();
        int gremioNum = scanner.nextInt();
        int interWins = 0;
        int gremioWins = 0;
        int empates = 0, grenais = 0;
        if(interNum > gremioNum){
            interWins++;
        } else if(interNum < gremioNum){
            gremioWins++;
        } else {
            empates++;
        }
        System.out.println("Novo grenal (1-sim 2-nao)");
        grenais++;
        int next = scanner.nextInt();
        while(next == 1){
            interNum = scanner.nextInt();
            gremioNum = scanner.nextInt();
            if(interNum > gremioNum){
                interWins++;
            } else if(interNum < gremioNum){
                gremioWins++;
            } else {
                empates++;
            }
            System.out.println("Novo grenal (1-sim 2-nao)");
            grenais++;
            next = scanner.nextInt();
        }
        System.out.println(grenais + " grenais");
        System.out.println("Inter:" + interWins);
        System.out.println("Gremio:" + gremioWins);
        System.out.println("Empates:" + empates);
        if(interWins > gremioWins){
            System.out.println("Inter venceu mais");
        } else if(interWins < gremioWins){
            System.out.println("Gremio venceu mais");
        } else {
            System.out.println("Empates venceu mais");
        }

    }

}