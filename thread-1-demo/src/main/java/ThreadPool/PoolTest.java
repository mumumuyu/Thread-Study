package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new ThreadTest());
        service.execute(new ThreadTest());
        service.execute(new ThreadTest());
        service.execute(new ThreadTest());
        service.execute(new ThreadTest());

        service.shutdown();
    }
}

class ThreadTest implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}