/*
Zadanie 3
Implement the following UML chart
Autor rozwiązania: Marek Kowalik
*/
package lab5;

public class Zad03Lab5 {
    static class MyTriangle {
        private Zad01Lab5.MyPoint v1;
        private Zad01Lab5.MyPoint v2;
        private Zad01Lab5.MyPoint v3;

        public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
            this.v1.setXY(x1, y1);
            this.v2.setXY(x2, y2);
            this.v3.setXY(x3, y3);
        }

        public MyTriangle(Zad01Lab5.MyPoint v1, Zad01Lab5.MyPoint v2, Zad01Lab5.MyPoint v3) {
            this.v1 = v1;
            this.v2 = v2;
            this.v3 = v3;
        }

        public String toString() {
            return "MyTriangle[v1=%s,v2=%s,v3=%s]".formatted(
                    this.v1.toString(), this.v2.toString(), this.v3.toString()
            );
        }

        public double getPerimeter() {
            double perimeter = 0;
            perimeter += this.v1.distance(this.v2);
            perimeter += this.v2.distance(this.v3);
            perimeter += this.v3.distance(this.v1);

            return perimeter;
        }

        public String getType() {
            double len_a = this.v1.distance(this.v2);
            double len_b = this.v2.distance(this.v3);
            double len_c = this.v3.distance(this.v1);

            if ( len_a == len_b && len_a == len_c ) {
                return "Equilateral";
            }
            if ( len_a == len_b || len_a == len_c || len_b == len_c ) {
                return "Isosceles";
            }
            return "Scalene";
        }
    }

    public static void main(String[] args) {
        MyTriangle t1 = new MyTriangle(0, 0, 1, 0, 0, 1); // right triangle
        MyTriangle t2 = new MyTriangle(0, 0, 1, 0, 1, 2); // isosceles
        MyTriangle t3 = new MyTriangle(
                new Zad01Lab5.MyPoint(0, 0),
                new Zad01Lab5.MyPoint(2, 0),
                new Zad01Lab5.MyPoint(1, 3)
        ); // almost equilateral (approx)

        MyTriangle[] triangles = {t1, t2, t3};

        for (int i = 0; i < triangles.length; i++) {
            System.out.println(triangles[i]);
            System.out.println("Perimeter: " + triangles[i].getPerimeter());
            System.out.println("Type: " + triangles[i].getType());
            System.out.println();
        }
    }
}
