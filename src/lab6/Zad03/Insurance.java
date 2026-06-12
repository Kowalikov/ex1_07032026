package lab6.Zad03;

public abstract class Insurance {
    private String type;
    private double costPerMonth;

    public Insurance(String type) {
        this.type = type;
    }

    abstract public void setCost();

    abstract public void display();
}
