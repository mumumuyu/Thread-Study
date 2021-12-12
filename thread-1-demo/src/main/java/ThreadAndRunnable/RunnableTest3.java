package ThreadAndRunnable;

public class RunnableTest3 implements Runnable{
    private Boolean flag = true;
    private int i;
    @Override
    public void run() {
        while(flag){
            if(i == 900) {
                System.out.println(Thread.currentThread().getName()+"停止了");
                stop();
            }
            System.out.println("run"+ i++);
        }
    }
    public void stop(){
        this.flag=false;
    }
    public static void main(String[] args) {
        new Thread(new RunnableTest3(),"run1").start();
        new Thread(new RunnableTest3(),"run2").start();
    }
}
