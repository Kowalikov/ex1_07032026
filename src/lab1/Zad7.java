package lab1;

import java.util.Scanner;


public class Zad7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // read n, m
            int n = sc.nextInt();
            int m = sc.nextInt();

            // validaet n, m
            if ( n<0 || m<0) { // ujemny element (nie naturalny)
                System.out.print("BŁĄD");
                return;
            }

            //create tabs
            int[] tab_1 = new int[n];
            int[] tab_2 = new int[m];

            //populate tabs
            for (int i=0; i < n; i++) {
                tab_1[i] = sc.nextInt();
                if (tab_1[i]<0) {
                    System.out.print("BŁĄD"); // ujemny element (nie naturalny)
                    return;
                }
            }
            for (int i=0; i < m; i++) {
                tab_2[i] = sc.nextInt();
                if (tab_2[i]<0) {
                    System.out.print("BŁĄD"); // ujemny element (nie naturalny)
                    return;
                }
            }

            // consider n!=m, before iloczyn skalarny
            if ( n!=m ) {
                System.out.print("BŁĄD."); // rózny rozmiar tablic
                return;
            }

            //print product
            int product = 0;
            for (int i=0; i < n; i++) {
                product += tab_1[i] * tab_2[i];
            }
            System.out.print(product);

        } catch (Exception e) {
            System.out.print("BŁĄD");
            return;
        }
    }
}