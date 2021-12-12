package RabbitAndWugui;

public class RAW implements Runnable{

    private String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(isWinner(i)) {
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
        }
    }

    public static void main(String[] args) {
        RAW raw = new RAW();
        new Thread(raw,"乌龟").start();
        new Thread(raw,"兔子").start();
    }

    public boolean isWinner(int step){
        if(winner!=null) {
            return true;
        }
        if(step == 100){
            winner = Thread.currentThread().getName();
            System.out.println("胜利者是"+winner);
            return true;
        }
        return false;
    }
}
