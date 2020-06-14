package Lesson1;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Mi-mi");
        Human human = new Human("Petya");
        Robot robot = new Robot("R2D2");

        Running[] runnings = {
                cat,
                human,
                robot
            };

        Jumping[] jumpings = {
                cat,
                human,
                robot
            };

        for (Running running : runnings) {
            running.run();
        }
        for (Jumping jumping : jumpings) {
            jumping.jump();
        }

    }
}
