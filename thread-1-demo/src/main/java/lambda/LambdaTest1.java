package lambda;

public class LambdaTest1 {

    public static void main(String[] args) {
        //局部内部类
        class Like3 implements Like{
            @Override
            public void lambda() {
                System.out.println("like3");
            }
        }
        Like like = new Like3();
        like.lambda();
        //匿名内部类
        like = new Like() {
            @Override
            public void lambda() {
                System.out.println("like5");
            }
        };
        like.lambda();
        //用lambda
        Like like1 = ()->{System.out.println("I like lambda6");};
        like1.lambda();
        Like like2 = ()->{System.out.println("like lambda7");};
        new Thread(()->System.out.println("多线程")).start();
    }
    //静态内部类
    static class Like4 implements Like{
        @Override
        public void lambda() {
            System.out.println("like4");
        }
    }
}
//定义一个函数式接口
interface Like{
    void lambda();
}

//实现
class Ilike implements Like{
    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}