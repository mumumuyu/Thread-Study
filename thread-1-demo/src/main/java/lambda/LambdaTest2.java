package lambda;

public class LambdaTest2 {
    public static void main(String[] args) {
        Loves loves;
        loves = (String name)->{
            System.out.println("I love youe," + name);
        };
        loves.love("lgd");
        //简化，去掉参数类型
        Loves love = (name)->{
            System.out.println("I love2"+name);
        };
        //去掉括号
        loves = name->{
            System.out.println("I love3"+name);
        };
        //去掉花括号
        loves = name-> System.out.println("I loves4"+name);
        Loves loves1 = name-> System.out.println("I love5" + name);

    }
}

interface Loves{
    void love(String name);
}
