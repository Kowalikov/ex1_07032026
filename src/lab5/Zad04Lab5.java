/*
Zadanie 4
Design a MyRectangle class which is composed of two MyPoint instances as
its top-left and bottom-right corners. Draw the class diagrams, write the
codes, and write the test drivers.
Autor rozwiązania: Marek Kowalik
*/
package lab5;

public class Zad04Lab5 {
    static class MyRectangle {
        private Zad01Lab5.MyPoint v1;
        private Zad01Lab5.MyPoint v2;

        public MyRectangle(int x1, int y1, int x2, int y2) {
            this.v1.setXY(x1, y1);
            this.v2.setXY(x2, y2);
        }

        public MyRectangle(Zad01Lab5.MyPoint v1, Zad01Lab5.MyPoint v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public String toString() {
            return "MyRectangle[v1=%s,v2=%s]".formatted(
                    this.v1.toString(), this.v2.toString()
            );
        }

        public double getPerimeter() {
            double perimeter = 0;
            perimeter += this.v1.distance(new Zad01Lab5.MyPoint(this.v2.getX(), this.v1.getY()));
            perimeter += this.v1.distance(new Zad01Lab5.MyPoint(this.v1.getX(), this.v2.getY()));
            perimeter *= 2;

            return perimeter;
        }

        public double getArea() {
            double len_a = this.v1.distance(new Zad01Lab5.MyPoint(this.v2.getX(), this.v1.getY()));
            double len_b = this.v1.distance(new Zad01Lab5.MyPoint(this.v1.getX(), this.v2.getY()));
            double area = len_a * len_b;

            return area;
        }
    }

    public static void main(String[] args) {
        MyRectangle r1 = new MyRectangle(0, 10, 5, 5);
        MyRectangle r2 = new MyRectangle(1, 1, 4, -2);
        MyRectangle r3 = new MyRectangle(
                new Zad01Lab5.MyPoint(2, 6),
                new Zad01Lab5.MyPoint(7, 2)
        );

        MyRectangle[] rectangles = {r1, r2, r3};

        for (int i = 0; i < rectangles.length; i++) {
            System.out.println(rectangles[i]);
            System.out.println("Perimeter: " + rectangles[i].getPerimeter());
            System.out.println("Area: " + rectangles[i].getArea());
            System.out.println();
        }
    }
}

