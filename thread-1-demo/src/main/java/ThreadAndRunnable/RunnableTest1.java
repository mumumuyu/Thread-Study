package ThreadAndRunnable;

public class RunnableTest1 implements Runnable{
    @Override
    public void run() {
        //run方法线程
        for (int i = 0; i < 100; i++) {
            System.out.println("runnable"+i);
        }
    }

    public static void main(String[] args) {
        new Thread(()-> {
            for (int i = 0; i < 100; i++) {
                System.out.println("lambda"+i);
            }
        }).start();
        new Thread(new RunnableTest1()).start();
        new Thread(new RunnableTest1()).start();
        //main 主线程
//        for (int i = 0; i < 200; i++) {
//            System.out.println("main"+i);
//        }

    }
}
