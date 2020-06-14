package Lesson1;

public class Robot implements Running, Jumping {
    String name;

    public Robot(String name) {
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
