package lab1;

import java.util.Scanner;


public class Zad12 {
    static double oblicz_wiek(int n_sekund, String planeta) {
        double wiek_ziemski = (double) n_sekund/31557600.0;

        switch (planeta){
            case "Ziemia":
                return wiek_ziemski;
            case "Merkury":
                return wiek_ziemski/0.2408467;
            case "Wenus":
                return wiek_ziemski/0.61519726;
            case "Mars":
                return wiek_ziemski/1.8808158;
            case "Jowisz":
                return wiek_ziemski/11.862615;
            case "Saturn":
                return wiek_ziemski/29.447498;
            case "Uran":
                return wiek_ziemski/84.016846;
            case "Neptun":
                return wiek_ziemski/164.79132;

            default:
                System.out.print("BŁĄD");
                return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int wiek_s;
        String planeta;
        try {
            wiek_s = sc.nextInt();
            planeta = sc.next();
            if (wiek_s<0) {
                System.out.print("BŁĄD");
                return;
            }
        } catch (Exception e) {
            System.out.print("BŁĄD");
            return;
        }

        double wiek = oblicz_wiek(wiek_s, planeta);

        if (wiek >= 0) {
            System.out.printf("%.2f", wiek);
        }
    }
}