package lab1;

import java.util.Scanner;


public class Zad5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Wprowadź numer miesiąca: ");
        int a;

        try {
            a = sc.nextInt();

            if (a < 1 || a > 12) {
                System.out.print("Rezultat: BŁĄD");
            } else {
                switch (a) {
                    case 1:
                        System.out.print("Rezultat: Styczeń 31 dni");
                        break;
                    case 2:
                        System.out.print("Rezultat: Luty 28 dni");
                        break;
                    case 3:
                        System.out.print("Rezultat: Marzec 31 dni");
                        break;
                    case 4:
                        System.out.print("Rezultat: Kwiecień 30 dni");
                        break;
                    case 5:
                        System.out.print("Rezultat: Maj 31 dni");
                        break;
                    case 6:
                        System.out.print("Rezultat: Czerwiec 30 dni");
                        break;
                    case 7:
                        System.out.print("Rezultat: Lipiec 31 dni");
                        break;
                    case 8:
                        System.out.print("Rezultat: Sierpień 31 dni");
                        break;
                    case 9:
                        System.out.print("Rezultat: Wrzesień 30 dni");
                        break;
                    case 10:
                        System.out.print("Rezultat: Październik 31 dni");
                        break;
                    case 11:
                        System.out.print("Rezultat: Listopad 30 dni");
                        break;
                    case 12:
                        System.out.print("Rezultat: Grudzień 31 dni");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.print("Rezultat: BŁĄD");
        }
    }
}