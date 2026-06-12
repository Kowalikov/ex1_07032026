package lab6.Zad03;

public class Life extends Insurance {
    private final String type = "Life";
    private double costPerMonth;

    public Life() {
        super("Life");
    }

    public void setCost() {
        this.costPerMonth = 36.0;
    }

    public void display() {
        System.out.println("Life insurance info:");
        System.out.println("\tCost per month: $%.2f".formatted(this.costPerMonth));
        System.out.println("\tBasic coverage: unfortunate events, death, cancer.");
    }
}