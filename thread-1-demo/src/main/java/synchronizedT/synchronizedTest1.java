package synchronizedT;

public class synchronizedTest1 {
    public static void main(String[] args) {
        Account account = new Account(1000,"lgd");
        Bank bank = new Bank(account,50,"lgd");
        Bank bank2 = new Bank(account,100,"lgd'sGirlFriend");
        bank.start();
        bank2.start();
    }

}

class Account{
    private int money;
    private String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Bank extends Thread{

    Account account;
    private int drawMoney;
    private int endMoney;
    private String name;

    public Bank(Account account,int drawMoney,String name) {
        this.name = name;
        this.account = account;
        this.drawMoney = drawMoney;
    }

    public void DrawMoney(){
        this.endMoney = account.getMoney()-this.drawMoney;
        account.setMoney(this.endMoney);
    }

    @Override
    public  void run() {
        synchronized (account){
            if(account.getMoney()-this.drawMoney<0){
                System.out.println(name+"钱不够啦");
                return;
            }
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("本来有"+account.getMoney());
            DrawMoney();
            System.out.println(name+"取走了"+drawMoney+"现在有"+endMoney);
        }
    }
}