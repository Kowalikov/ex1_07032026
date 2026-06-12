/*
Implement the following UML chart
*/


package lab6;

public class Zad02Lab6 {
    public static interface GeometricObject {
        double getPerimeter();
        double getArea();
    }

    public static class Circle implements GeometricObject {
        protected double radius = 1.0;

        public Circle() { }

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getPerimeter() {
            return 2 * Math.PI * this.radius;
        }

        public double getArea() {
            return Math.PI * Math.pow(this.radius, 2);
        }
    }

    public static interface Resizable {
        public void resize(int percent);
    }

    public static class ResizableCircle extends Circle implements Resizable {
        public ResizableCircle(double radius) {
            super(radius);
        }

        public void resize(int percent) {
            this.radius = this.radius * (double)percent / 100.0;
        }
    }

    public static void main(String[] args) {
        // Test 1
        Circle c1 = new Circle(5.0);

        System.out.println("Circle:");
        System.out.println("\tRadius: 5.0");
        System.out.println("\tPerimeter: " + c1.getPerimeter());
        System.out.println("\tArea: " + c1.getArea());

        System.out.println();

        // Test 2
        ResizableCircle rc1 = new ResizableCircle(10.0);

        System.out.println("ResizableCircle:");
        System.out.println("\tOriginal radius: 10.0");
        System.out.println("\tArea before resize: " + rc1.getArea());
        System.out.println("\tPerimeter before resize: " + rc1.getPerimeter());

        rc1.resize(50);

        System.out.println("After resize(50%):");
        System.out.println("\tNew area: " + rc1.getArea());
        System.out.println("\tNew perimeter: " + rc1.getPerimeter());
    }
}
