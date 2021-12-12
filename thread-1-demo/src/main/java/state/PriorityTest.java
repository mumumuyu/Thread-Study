package state;

public class PriorityTest implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new PriorityTest(),"1");
        Thread thread2 = new Thread(new PriorityTest(),"2");
        Thread thread3 = new Thread(new PriorityTest(),"3");
        Thread thread4 = new Thread(new PriorityTest(),"4");
        Thread thread5 = new Thread(new PriorityTest(),"5");
        //先设置优先级再启动
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(3);
        thread3.setPriority(Thread.NORM_PRIORITY);
        thread4.setPriority(7);
        thread5.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
