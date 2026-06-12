package lab6.Zad03;

public class Health extends Insurance {
    private final String type = "Health";
    private double costPerMonth;

    public Health() {
        super("Health");
    }

    public void setCost() {
        this.costPerMonth = 196.0;
    }

    public void display() {
        System.out.println("Health insurance info:");
        System.out.println("\tCost per month: $%.2f".formatted(this.costPerMonth));
        System.out.println("\tBasic coverage: dental, exams, hospital residence, doctors appointments.");
    }
}