import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class TriangleTypes {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();
        double c = Math.min(Math.min(side1, side2), side3);
        double a = Math.max(Math.max(side1, side2), side3);
        double b = 0;
        if((a == side1 && c == side2) || (a == side2 && c == side1)){
            b = side3;
        } else if((a == side1 && c == side3) || (a == side3 && c == side1)){
            b = side2;
        } else {
            b = side1;
        }

        if(a >= b + c){
            System.out.println("NAO FORMA TRIANGULO");
        } else {
            if(Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c,2)){
                System.out.println("TRIANGULO RETANGULO");
            }
            if(Math.pow(a, 2) > Math.pow(b, 2) + Math.pow(c,2)){
                System.out.println("TRIANGULO OBTUSANGULO");
            }
            if(Math.pow(a, 2) < Math.pow(b, 2) + Math.pow(c,2)){
                System.out.println("TRIANGULO ACUTANGULO");
            }
            if(a == b && b == c){
                System.out.println("TRIANGULO EQUILATERO");
            }
            if((a == b && b != c) || (a != b && b == c) || (a == c && b != c)){
                System.out.println("TRIANGULO ISOSCELES");
            }
        }

    }

}
