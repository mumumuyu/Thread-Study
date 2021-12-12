package OldHomeWork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class StringsTest implements Runnable{
    private static String[] str={"A","B","C","D","E","F","G","H","I","J","K"};
    int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true) {
        lock.lock();
        try {
            if(count>=11){
                return;
            }
            System.out.println(str[count++] + Thread.currentThread().getName());
            } finally  {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        StringsTest test = new StringsTest();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(test);
        service.execute(test);
        service.execute(test);
        service.shutdown();
    }
}
