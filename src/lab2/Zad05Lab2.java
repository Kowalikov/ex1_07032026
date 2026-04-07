/*
Zadanie 5:
Zaimplementuj klasę Numbers. Dodaj konstruktor który przyjmuje trzy liczby typu
integer. Dodaj metody:
- sum(), zwraca sumę liczb;
- average(), zwraca średnią arytmetyczną liczb;
- min(), zwraca najmniejszą z liczb;
- max(), zwraca największą z liczb;
- geometric(), zwraca średnią geometryczną liczb;

Przetestuj zaimplementowany program.
Autor rozwiązania: Marek Kowalik
*/
package lab2;


public class Zad05Lab2 {
    public static class Numbers {
        private int[] n_list;

        public Numbers(int x, int y, int z) {
            n_list = new int[]{x, y, z};
        }

        public int sum() {
            int n_sum = 0;
            for (int n : n_list) {
                n_sum += n;
            }

            return n_sum;
        }

        public double average() {
            return ((double)(sum())) / n_list.length;
        }

        public int min() {
            int n_min = n_list[0];
            for (int n : n_list) {
                n_min = Math.min(n_min, n);
            }

            return n_min;
        }

        public int max() {
            int n_max = n_list[0];
            for (int n : n_list) {
                n_max = Math.max(n_max, n);
            }

            return n_max;
        }

        public double geometric() {
            double product = 1;
            for (int n : n_list) {
                product *= n;
            }
            return Math.pow(product, 1.0/n_list.length);
        }

        public String toString() {
            String s = "{";
            for (int i = 0; i < n_list.length; i++) {
                if (i > 0) {
                    s += ", ";
                }
                s += "%d".formatted(n_list[i]);
            }
            s += "}";

            return s;
        }
    }

    public static void main(String[] args) {
        Numbers ns = new Numbers(1, 2, 3);

        IO.println("Numbers: " + ns);
        IO.println("\tSuma:      " + ns.sum());
        IO.println("\tŚrednia:   %.3f".formatted(ns.average()));
        IO.println("\tMin:       " + ns.min());
        IO.println("\tMax:       " + ns.max());
        IO.println("\tŚr. geom.: %.3f".formatted(ns.geometric()));
    }
}
