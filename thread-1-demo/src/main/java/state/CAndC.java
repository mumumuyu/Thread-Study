package state;

public class CAndC {
    public static void main(String[] args) {
        Container container = new Container();
        Productor productor = new Productor(container);
        Consumer consumer = new Consumer(container);
        productor.start();
        consumer.start();
    }
}

class Productor extends Thread{
    Container container;

    public Productor(Container container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                container.add(new Product(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("add 了" + i +"只鸡");
        }
    }
}

class Consumer extends Thread{
    Container container;

    public Consumer(Container container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Product product = container.eat();
                System.out.println("吃了"+product.id+"只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Product{
    int id;

    public Product(int id){
        this.id = id;
    }
}

class Container{
    Product[] products = new Product[10];

    int count = 0;

    public synchronized void add(Product product) throws InterruptedException {
        while(count==products.length){
            this.wait();
        }
        products[count]=product;
        count++;
        this.notifyAll();
    }

    public synchronized Product eat() throws InterruptedException {
        while(count==0){
            this.wait();
        }
        count--;
        Product product = products[count];
        this.notifyAll();
        return product;
    }
}