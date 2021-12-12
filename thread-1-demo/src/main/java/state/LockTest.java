package state;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable{

    int tickets = 10;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if(tickets<=0) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "-->" + tickets--);
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        new Thread(lockTest,"1").start();
        new Thread(lockTest,"2").start();
        new Thread(lockTest,"3").start();
    }
}
