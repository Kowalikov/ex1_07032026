import java.util.Scanner;
import java.util.Arrays;


public class Zad13 {
    static double najwiekszy_element(double[] n) {
        if (n.length==0) {
            return 0.0;
        } else if (n.length==1) {
            return n[0];
        } else if (n.length==2) {
            return Math.max(n[0], n[1]);
        } else {
            return Math.max(
                    najwiekszy_element(Arrays.copyOf(n, n.length - 1)),
                    n[n.length-1]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Read list
            String line = sc.nextLine();
            String[] parts = line.trim().split("\\s+");

            int limit=parts.length;
            double[] tab = new double[limit];
            for (int i=0; i<limit; i++) {
                tab[i] = Double.parseDouble(parts[i]);
            }

            // Find the largest value
            double max_el = najwiekszy_element(tab);

            if (max_el == Math.floor(max_el)) {
                System.out.printf("%d ", (int) max_el);
            } else {
                System.out.printf("%.2f ", max_el);
            }
        } catch (Exception e) {
            System.out.print("BŁĄD");
            return;
        }

    }
}