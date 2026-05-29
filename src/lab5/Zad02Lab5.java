/*
Zadanie 2
Implement the following UML chart
Autor rozwiązania: Marek Kowalik
*/
package lab5;

public class Zad02Lab5 {
    static class MyCircle {
        private Zad01Lab5.MyPoint center = new Zad01Lab5.MyPoint(0,0);
        private int radius = 1;

        public MyCircle() {}

        public MyCircle(int x, int y, int radius) {
            this.center = new Zad01Lab5.MyPoint(x,y);
            if ( radius < 0 )
                this.radius = 0;
            else
                this.radius = radius;
        }

        public MyCircle(Zad01Lab5.MyPoint point, int radius) {
            this.center = point;
            if ( radius < 0 )
                this.radius = 0;
            else
                this.radius = radius;
        }

        public int getRadius() {
            return this.radius;
        }

        public void setRadius(int r) {
            if ( r < 0 )
                this.radius = 0;
            else
                this.radius = r;
        }

        public Zad01Lab5.MyPoint getCenter() {
            return this.center;
        }

        public void setCenter(Zad01Lab5.MyPoint p) {
            this.center = p;
        }

        public int getCenterX() {
            return this.center.getX();
        }

        public void setCenterX(int x) {
            this.center.setX(x);
        }

        public int getCenterY() {
            return this.center.getY();
        }

        public void setCenterY(int y) {
            this.center.setY(y);
        }

        public int[] getCenterXY() {
            return new int[] {this.center.getX(), this.center.getY()};
        }

        public void setCenterXY(int x, int y) {
            this.setCenterX(x);
            this.setCenterY(y);
        }

        public String toString() {
            return "MyCircle[radius=%d,center=%s]".formatted(this.radius, this.center.toString());
        }

        public double getArea() {
            return Math.PI * Math.pow(this.radius, 2);
        }

        public double getCircumference() {
            return Math.PI * this.radius * 2;
        }

        public double distance(MyCircle c2) {
            double distance = this.center.distance(c2.center);
            distance -= (this.radius + c2.radius);
            if ( distance < 0.0 )
                return 0.0;
            else
                return distance;
        }
    }

    public static void main(String[] args) {
        MyCircle c1 = new MyCircle(0, 0, 1);
        MyCircle c2 = new MyCircle(3, 4, 2);
        MyCircle c3 = new MyCircle(new Zad01Lab5.MyPoint(6, 8), 3);

        MyCircle[] circles = {c1, c2, c3};

        for (int i = 0; i < circles.length; i++) {
            System.out.println(circles[i]);
            System.out.println("Area: " + circles[i].getArea());
            System.out.println("Circumference: " + circles[i].getCircumference());

            if (i >= 1) {
                System.out.println("Distance to previous: " +
                        circles[i].distance(circles[i - 1]));
            }

            System.out.println();
        }
    }
}
