import java.util.Scanner;


public class zad1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Wprowadź a: ");
        double a = sc.nextDouble();

        System.out.print("Wprowadź b: ");
        double b = sc.nextDouble();

        System.out.print("Wynik: "+ a*b);
    }
}