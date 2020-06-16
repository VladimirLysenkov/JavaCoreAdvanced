package Lesson1;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {
                new Cat ("Mi-mi"),
                new Human ("Petya"),
                new Robot ("R2D2"),
                new Human("Vasya")
            };

        Obstacle[] obstacles = {
               new Wall(10),
               new RunningTrack(700)
        };

        for (Participant participant:participants) {
            for (Obstacle obstacle:obstacles) {
                obstacle.doIt(participant);
                if (!participant.isInvolved()) {
                    break;
                }
            }
        }
        for (Participant participant : participants) {
            participant.getInfo();
        }
    }
}
