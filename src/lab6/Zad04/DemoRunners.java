package lab6.Zad04;

public class DemoRunners {
    public static void main(String[] args) {
        System.out.println("Welcome to app enjoying the running homonym!\n");
        System.out.print("Let's go through the different meanings:\n");

        System.out.print("\nAthlete:\n");
        Athlete athlete = new Athlete();
        athlete.run();

        System.out.print("\nMachine:\n");
        Machine machine = new Machine();
        machine.run();

        System.out.print("\nPolitical Candidate:\n");
        PoliticalCandidate politicalCandidate = new PoliticalCandidate();
        politicalCandidate.run();
    }
}
