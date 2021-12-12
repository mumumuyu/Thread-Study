package ThreadAndRunnable;

public class RunnableTest2 implements Runnable{

    private int tickerName = 10;
    @Override
    public synchronized void run() {
        while(true) {
            if (tickerName <= 0){
                System.out.println("手慢了，票子拿完咯");
                break;
            }else{
                //延迟0.2秒再让你抢
                try {
                    Thread.sleep(200);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"拿到了"+tickerName--+"张票");
            }
        }
    }

    public static void main(String[] args) {
        RunnableTest2 runnableTest2 = new RunnableTest2();
        new Thread(runnableTest2,"小明").start();
        new Thread(runnableTest2,"小红").start();
        new Thread(runnableTest2,"黄牛").start();
    }
}
