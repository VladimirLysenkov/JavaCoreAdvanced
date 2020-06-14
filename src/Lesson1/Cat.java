package Lesson1;

public class Cat implements Running, Jumping {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " run...");
    }

    @Override
    public void jump() {
        System.out.println(name + " jump...");
    }
}
