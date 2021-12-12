package state;

public class DeadLock {
    public static void main(String[] args) {
        MakeUp makeUp = new MakeUp(1,"lgd");
        MakeUp makeUp1 = new MakeUp(0,"lgd2");
        makeUp.start();
        makeUp1.start();
    }
}

class Fish{
}

class Pig{
}

class MakeUp extends Thread{
    static Fish fish = new Fish();
    static Pig pig = new Pig();

    int choice;
    String name;

    public MakeUp(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        if(choice==1){
            synchronized (fish){
                System.out.println(name+"获得了fish");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (pig){
                    System.out.println(name + "获得了pig");
                }
            }
        }else{
            synchronized (pig){
                System.out.println(name + "获得了pig");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fish){
                    System.out.println(name+"获得了fish");
                }
            }
        }
    }
}
