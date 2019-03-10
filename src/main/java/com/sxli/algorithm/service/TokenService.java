package main.java.com.sxli.algorithm.service;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TokenService {

    private RateLimiter rateLimiter = RateLimiter.create(7.0);

    public boolean getToken(){
        return rateLimiter.tryAcquire(1,1, TimeUnit.SECONDS);
    }

}
