package concurrency;

import java.util.*;

class TeamTC1 implements Runnable {

    List<String> team = new ArrayList<String>(Arrays.asList("Mark Bennett", "Abram Jablonski", "Caleb Waters","Cody Clark",
            "John Bozarov", "Kevin Keesee", "Matthew Choat", "Tyler Clements", "Zach", "Aaron White", "Gotham Katta", "Justin Cheng", "Korey Brooks", "Sarah"));
    String printTeam = "";
    //This thread should be created by implementing the Runnable interface, NOT by extending the Thread class.  In the run method of this thread, print out the name of each student in your TA group, (starting with your TA).  There should be a pause of 1 second before each name is printed to the console.The name should then be pushed to the team List  After all the names have been pushed to this List, print out the entire list of all the students in your TA group. Don't forget your TA as well!  All of these steps should be done whenever the thread is started.  (i.e. it can be done directly in the run()method of the thread itself).  Kick off the thread in the Main class of the concurrency package.
    public void run() {
        try {
            List<String> finishedTeam = new ArrayList<String>();
            for(String person: team) {
                System.out.println(person);
                Thread.sleep(1L * 1000L);
                finishedTeam.add(person);
            }
            System.out.println("TA: " + finishedTeam.get(0) + "\nStudents:");
            for(int i = 1; i < finishedTeam.size(); i++){
                if((i+1) != finishedTeam.size()){
                    printTeam += (finishedTeam.get(i) + ", ");
                } else {
                    printTeam += (finishedTeam.get(i) + ".");
                }
            }
            System.out.println(printTeam);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}