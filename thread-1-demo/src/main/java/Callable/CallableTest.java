package Callable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class CallableTest implements Callable<Boolean> {
    private String url;
    private String name;

    public CallableTest(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownLoader webDownLoader = new WebDownLoader();
        try {
            webDownLoader.downloader(url,name);
            System.out.println("下载了文件"+name);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest t1 = new CallableTest("http://n.sinaimg.cn/translate/20170405/ztw2-fycxmks5744567.jpg","t1");
        CallableTest t2 = new CallableTest("http://n.sinaimg.cn/translate/20170405/-iOC-fycwyns4929565.jpg","t2");
        CallableTest t3 = new CallableTest("http://n.sinaimg.cn/translate/20170405/i8ct-fycxmks5744699.jpg","t3");

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = service.submit(t1);
        Future<Boolean> r2 = service.submit(t2);
        Future<Boolean> r3 = service.submit(t3);
        //获取结果
        Boolean b1 = r1.get();
        Boolean b2 = r2.get();
        Boolean b3 = r3.get();
        //关闭服务
        service.shutdownNow();
    }
}

class WebDownLoader{
    public void downloader(String url,String name) throws IOException {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}
