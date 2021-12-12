package state.yield;

public class YieldTest implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"执行结束");
    }

    public static void main(String[] args) {
        new Thread(new YieldTest(),"线程1").start();
        new Thread(new YieldTest(),"线程2").start();
    }
}
