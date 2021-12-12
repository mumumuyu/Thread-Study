package state;

public class DaemonTest {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 36500; i++) {
                System.out.println("我活的第"+i+"天");
            }
            System.out.println("bye~world!");
        });

        Thread thread2 = new Thread(()->{
            while(true){
                System.out.println("family daemon me");
            }
        });

        thread2.setDaemon(true);
        thread2.start();
        thread.start();
    }
}