/*
Implement the following UML chart
*/

package lab6;

public class Zad01Lab6 {
    public interface Movable {
        void setSpeed(int xSpeed, int ySpeed);

        int[] getSpeed();
    }

    public static class MovablePoint implements Movable {
        private int x;
        private int y;
        private int[] speed = {0, 0};

        public MovablePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setXY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setSpeed(int x, int y) {
            this.speed = new int[] {x, y};
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int[] getSpeed() {
            return this.speed;
        }

        public String toString() {
            return "(%d,%d)".formatted(this.x, this.y);
        }
    }

    public static class MovableRectangle implements Movable {
        private MovablePoint topLeft;
        private MovablePoint bottomRight;
        private int[] speed = {0, 0};

        public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
            this.topLeft = new MovablePoint(x1, y1);
            this.bottomRight = new MovablePoint(x2, y2);

            this.speed = new int[]{xSpeed, ySpeed};
        }

        public void setSpeed(int xSpeed, int ySpeed) {
            this.speed = new int[] {xSpeed, ySpeed};
        }

        public int[] getSpeed() {
            return this.speed;
        }

        public String toString() {
            return "MyMovableRectangle[a1=%s,a2=%s,v=(%d,%d)]".formatted(
                    this.topLeft.toString(),
                    this.bottomRight.toString(),
                    this.speed[0],
                    this.speed[1]
            );
        }

        public void moveUp() {
            topLeft.setY(topLeft.getY() + speed[1]);
            bottomRight.setY(bottomRight.getY() + speed[1]);
        }

        public void moveDown() {
            topLeft.setY(topLeft.getY() - speed[1]);
            bottomRight.setY(bottomRight.getY() - speed[1]);
        }

        public void moveRight() {
            topLeft.setX(topLeft.getX() + speed[0]);
            bottomRight.setX(bottomRight.getX() + speed[0]);
        }

        public void moveLeft() {
            topLeft.setX(topLeft.getX() - speed[0]);
            bottomRight.setX(bottomRight.getX() - speed[0]);
        }
    }

    public static void main(String[] args) {

        // Example 1
        MovableRectangle rect1 = new MovableRectangle(0, 0, 5, 5, 1, 1);
        System.out.println("Before move (rect1): " + rect1);

        rect1.moveUp();
        rect1.moveRight();

        System.out.println("After move (rect1): " + rect1);

        System.out.println();

        // Example 2
        MovableRectangle rect2 = new  MovableRectangle(10, 10, 20, 20, 2, 3);
        System.out.println("Before move (rect2): " + rect2);

        rect2.moveDown();
        rect2.moveLeft();

        System.out.println("After move (rect2): " + rect2);
    }

}
