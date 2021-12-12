package state.staticDaiLi;

public interface MarryByDaili {
    void HappryMarry();

    public static void main(String[] args) {
        new DaiLi().HappryMarry();
    }
}

class MeA implements MarryByDaili{
    @Override
    public void HappryMarry() {
        System.out.println("marrying");
    }
}

class DaiLi implements MarryByDaili{
    @Override
    public void HappryMarry() {
        before();
        new MeA().HappryMarry();
        after();
    }

    void before(){
        System.out.println("marry before");
    }

    void after(){
        System.out.println("marry after");
    }
}

