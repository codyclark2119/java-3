package concurrency;

public class Main {
   
    public static void main(String[] args) {
         //run all of your threads from this main class.
        Reasoning reasoning = new Reasoning();
        reasoning.start();
        TeamTC1 team1 = new TeamTC1();
        Thread thread = new Thread(team1);
        thread.start();
    }
}