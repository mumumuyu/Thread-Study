package state.join;

public class JoinTest implements Runnable {

    int i = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("run" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new JoinTest());
        thread.start();
        for (int i = 0; i < 100; i++) {
            if (i == 50) {
                thread.join();
            }
            System.out.println("main" + i);
        }
    }
}