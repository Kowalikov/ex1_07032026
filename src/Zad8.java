import java.util.Scanner;


public class Zad8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean valid_input = false;

        int n=0;
        while (!valid_input) {
            try {
                n = sc.nextInt();
            } catch (Exception e) {
                continue;
            }
            if (n>=0) {
                valid_input = true;
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                System.out.printf("*");
            }
            System.out.printf("%n");
        }
        for (int i=n; i>=1; i--) {
            for (int j=1; j<=i; j++) {
                System.out.printf("*");
            }
            System.out.printf("%n");
        }

        for (int i=n; i>=1; i--) {
            for (int j=1; j<=n-i; j++) {
                System.out.printf(" ");
            }
            for (int j=1; j<=i; j++) {
                System.out.printf("*");
            }
            System.out.printf("%n");
        }
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n-i; j++) {
                System.out.printf(" ");
            }
            for (int j=1; j<=i; j++) {
                System.out.printf("*");
            }
            System.out.printf("%n");
        }

    }
}