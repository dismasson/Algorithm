package main.java.com.sxli.algorithm.flowlimit;

import com.google.common.util.concurrent.RateLimiter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RatelimitTest {

    private static String sendGet(String url){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(url);
            HttpResponse response = client.execute(get);
            HttpEntity httpentity = response.getEntity();
            String resq = EntityUtils.toString(httpentity);
            stringBuilder.append(resq);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        /*ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i ++){
            final int index = i+1;
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("本次请求序号为：" + index + ",本次请求返回结果：" + sendGet("http://localhost:8091/getToken") );
                }
            });
        }*/
        final RateLimiter rtl = RateLimiter.create(10.0);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Name:" + Thread.currentThread().getName() + "是否获取到许可证：" + rtl.tryAcquire(1,1, TimeUnit.SECONDS));
            }
        };
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i ++){
            es.execute(runnable);
        }
    }
}
