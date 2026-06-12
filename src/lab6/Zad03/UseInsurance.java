package lab6.Zad03;
import java.util.Scanner;

public class UseInsurance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the insurance system!\n");
        System.out.print("Please insert type of insurance to use [Health/Life]:");
        String word = scanner.next();
        scanner.close();

        if (word.equals("Health") || word.equals("Life")) {
            System.out.println("You entered type: " + word);

            Insurance insurance;
            if (word.equals("Health")) {
                insurance = new Health();
            } else {
                insurance = new Life();
            }
            insurance.setCost();
            insurance.display();

        } else {
            System.out.println("You entered: " + word);
            System.out.println("Type of insurance not recognized. Closing the app.");
        }
    }
}
