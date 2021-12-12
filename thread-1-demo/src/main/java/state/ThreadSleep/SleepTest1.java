package state.ThreadSleep;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepTest1 {
    public static void main(String[] args) throws InterruptedException {
        Date startTime = new Date(System.currentTimeMillis());
        for (int i = 1; i <= 10; i++) {
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            Thread.sleep(1000);
            startTime = new Date(System.currentTimeMillis());
        }
    }
}
