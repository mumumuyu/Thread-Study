package state.staticDaiLi;

public interface Marry {
    void happyMarry();

    public static void main(String[] args) {
        Agent agent = new Agent(new Me());
        agent.happyMarry();
    }
}

class Me implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("lgd今天结婚");
    }
}
class Agent implements  Marry{

    private Marry target;

    public Agent(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        target.happyMarry();
        after();
    }

    void before(){
        System.out.println("结婚前准备");
    }
    void after(){
        System.out.println("结婚完后");
    }
}