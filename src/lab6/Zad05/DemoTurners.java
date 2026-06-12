package lab6.Zad05;


public class DemoTurners {
    public static void main(String[] args) {
        System.out.println("Welcome to app turning Turners!\n");
        System.out.print("Let's turn:\n");

        System.out.print("\nLeaf turn:\n");
        Leaf leaf = new Leaf();
        leaf.turn();

        System.out.print("\nPage turn:\n");
        Page page = new Page();
        page.turn();

        System.out.print("\nPancake turn:\n");
        Pancake pancake = new Pancake();
        pancake.turn();
    }
}
