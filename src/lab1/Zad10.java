package lab1;

import java.util.Scanner;


public class Zad10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if ( a<=0 || b<=0) {
                System.out.print("BŁĄD");
                return;
            }

            //create tabs
            double[][] tab = new double[a][b];

            //populate tabs
            for (int i=0; i < a; i++) {
                for (int j=0; j < b; j++) {
                    tab[i][j] = sc.nextDouble();
                }
            }
            for (int j=0; j < b; j++) {
                for (int i=0; i < a; i++) {
                    if (tab[i][j] == Math.floor(tab[i][j])) {
                        System.out.printf("%d ", (int) tab[i][j]);
                    } else {
                        System.out.printf("%f ", tab[i][j]);
                    }
                }
            }

        } catch (Exception e) {
            System.out.print("BŁĄD");
            return;
        }
    }
}