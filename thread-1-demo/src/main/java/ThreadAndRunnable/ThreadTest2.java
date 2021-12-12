package ThreadAndRunnable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ThreadTest2 extends Thread{
    private String url;
    private String name;

    public ThreadTest2(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        try {
            webDownLoader.downloader(url,name);
            System.out.println("下载了文件"+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadTest2 t1 = new ThreadTest2("http://n.sinaimg.cn/translate/20170405/ztw2-fycxmks5744567.jpg","t1");
        ThreadTest2 t2 = new ThreadTest2("http://n.sinaimg.cn/translate/20170405/-iOC-fycwyns4929565.jpg","t2");
        ThreadTest2 t3 = new ThreadTest2("http://n.sinaimg.cn/translate/20170405/i8ct-fycxmks5744699.jpg","t3");

        t1.start();
        t2.start();
        t3.start();

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
