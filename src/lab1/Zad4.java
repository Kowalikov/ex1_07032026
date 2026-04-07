package lab1;

import java.util.Scanner;


public class Zad4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Wprowadź a, b i c: ");
        double a, b, c;
        try {
            a = sc.nextDouble();
            b = sc.nextDouble();
            c = sc.nextDouble();

            if (a<=0 || b<=0 || c<=0) {
                System.out.print("Rezultat: BŁĄD");
            } else if (a+b>c && a+c>b && b+c>a) {
                System.out.print("Rezultat: TAK");
            } else {
                System.out.print("Rezultat: NIE");
            }
        } catch (Exception e) {
            System.out.print("Rezultat: BŁĄD");
        }

    }
}