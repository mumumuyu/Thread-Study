package OldHomeWork;
import java.util.concurrent.*;

public class AccountTest {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();
        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }
    //执行存
    public static class DepositTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    account.deposit((int) (Math.random() * 10) + 1);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    //执行取
    public static class WithdrawTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                account.withdraw((int) (Math.random() * 10) + 1);
            }
        }
    }

    private static class Account {
        private static Object newDeposit = new Object();
        private int balance = 0;

        public int getBalance() {
            return balance;
        }
        //取
        public void withdraw(int amount) {
            synchronized (newDeposit) {
                while (balance < amount) {
                    System.out.println("\t\t\twait for a deposit");
                    try {
                        newDeposit.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                balance -= amount;
                System.out.println("\t\t\twithdraw " + amount + "\t\t" + getBalance());
            }
        }

        //存
        public void deposit(int amount) {
            synchronized (newDeposit) {
                try {
                    balance += amount;
                    System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
                    newDeposit.notifyAll();
                } finally {
                }
            }
        }
    }
}
