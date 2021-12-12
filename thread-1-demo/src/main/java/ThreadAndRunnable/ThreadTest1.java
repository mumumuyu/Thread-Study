package ThreadAndRunnable;

public class ThreadTest1 extends Thread{
    @Override
    public void run() {
        //run方法线程
        for (int i = 0; i < 100; i++) {
            System.out.println("run"+i);
        }
    }

    public static void main(String[] args) {
        ThreadTest1 threadTest1 =new ThreadTest1();
        threadTest1.start();

        //main 主线程
        for (int i = 0; i < 200; i++) {
            System.out.println("main"+i);
        }

    }
}
