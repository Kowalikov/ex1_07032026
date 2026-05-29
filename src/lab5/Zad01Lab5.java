/*
Zadanie 1
Implement the following UML chart
Write a program that allocates 10 points in an array of MyPoint, and
initializes to (1, 1), (2, 2), ... (10, 10).
Autor rozwiązania: Marek Kowalik
*/
package lab5;

import java.util.*;

public class Zad01Lab5 {
    static class MyPoint {
        private int x = 0;
        private int y = 0;

        public MyPoint() {}

        public MyPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return this.y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int[] getXY() {
            return new int[] {this.x, this.y};
        }

        public void setXY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(%d,%d)".formatted(this.x, this.y);
        }

        public double distance(MyPoint point) {
            return Math.sqrt(Math.pow(this.x - point.getX(), 2) + Math.pow(this.y - point.getY(), 2));
        }

        public double distance(int x, int y) {
            return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
        }

        public double distance() {
            return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        }
    }

    public static void main(String[] args) {
        MyPoint[] myPoints = new MyPoint[10];

        for (int i = 0; i < 10; i++) {
            myPoints[i] = new MyPoint(i+1, i+1);
        }

        for (int i=0; i<10; i++) {
            System.out.println(myPoints[i].toString());
            System.out.println(myPoints[i].distance());
            if ( i >= 1 ) {
                System.out.println(myPoints[i].distance(myPoints[i-1]));
            }
        }
    }
}
