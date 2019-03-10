package main.java.com.sxli.algorithm.controller;

import main.java.com.sxli.algorithm.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimiterController {

    @Autowired
    private TokenService ts;

    @RequestMapping(value = "/getToken",method = RequestMethod.GET)
    public String getToken(){
        StringBuilder stringBuilder = new StringBuilder();
        if(ts.getToken()){
            //模拟业务执行500毫秒
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            stringBuilder.append("恭喜您，获取到了令牌!");
        }else{
            stringBuilder.append("很遗憾，你未曾获取到令牌!");
        }
        return stringBuilder.toString();
    }

}
