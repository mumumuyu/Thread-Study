package OldHomeWork;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Pool {
    public static Integer sum = new Integer(0);
    private final static ReentrantLock lock = new ReentrantLock();

    static class AddTask implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                sum += 1;
                System.out.println(sum);
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            service.execute(new AddTask());
        }
        service.shutdown();
    }
}
