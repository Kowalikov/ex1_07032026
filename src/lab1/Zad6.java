package lab1;

import java.util.Scanner;


public class Zad6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Wprowadź a, b i c: ");
        double a, b, c;
        try {
            a = sc.nextDouble();
            b = sc.nextDouble();
            c = sc.nextDouble();

            String pattern = "%.6f %.6f %.6f %.6f %.6f %.6f%n";
            if (a <= b && a <= c) {
                if (b <= c) {
                    System.out.printf(pattern, a, b, c, c, b, a);
                } else {
                    System.out.printf(pattern, a, c, b, b, c, a);
                }
            } else if (b <= a && b <= c) {
                if (a <= c) {
                    System.out.printf(pattern, b, a, c, c, a, b);
                } else {
                    System.out.printf(pattern, b, c, a, a, c, b);
                }
            } else {
                if (a <= b) {
                    System.out.printf(pattern, c, a, b, b, a, c);
                } else {
                    System.out.printf(pattern, c, b, a, a, b, c);
                }
            }
        } catch (Exception e) {
            System.out.print("Rezultat: BŁĄD");
        }
    }
}