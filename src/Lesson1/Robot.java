package Lesson1;

public class Robot implements Participant {
    String name;
    int maxRunDistance;
    int maxJumpHeight;
    boolean isInvolved;


    public Robot(String name) {
        this.name = name;
        this.maxRunDistance = 100;
        this.maxJumpHeight = 0;
        this.isInvolved = true;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance){
            System.out.println(name + " успешно пробежал дистанцию.");
        } else {
            System.out.println(name + " не смог пробежать дистанцию.");
            isInvolved = false;
        }

    }

    @Override
    public void jump(int height) {
        if (maxJumpHeight == 0) {
            System.out.println(name + " не умеет прыгать.");
            isInvolved = false;
            return;
        }
        if (height <= maxJumpHeight){
            System.out.println(name + " успешно перепрыгнул препятствие.");
        } else {
            System.out.println(name + " не смог перепрыгнуть препятствие.");
            isInvolved = false;
        }
    }

    @Override
    public boolean isInvolved() {
        return isInvolved;
    }

    @Override
    public void getInfo() {
        System.out.println(name + ": " + isInvolved);
    }
}
