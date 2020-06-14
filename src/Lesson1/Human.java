package Lesson1;

public class Human implements Running, Jumping {
    String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public void jump() {
        System.out.println(name + " jump...");
    }

    @Override
    public void run() {
        System.out.println(name + " run...");
    }
}
