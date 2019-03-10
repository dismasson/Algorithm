package com.sxli.algorithm.flowlimit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Ratelimiter源码解析
 */
public class RateLimiterAnalysis {

    //每秒两个令牌
    private static RateLimiter one = RateLimiter.create(2.0);

    //每秒两个令牌
    private static RateLimiter two = RateLimiter.create(2.0);

    public static void acquire(RateLimiter rateLimiter,int num){
        double waitTime = rateLimiter.acquire(num);
        System.out.println("wait time = " + waitTime);
    }

    public static void main(String[] args) throws InterruptedException {
        acquire(one,1);
        acquire(one,1);
        acquire(one,1);
        System.out.println("-----");
        acquire(two,10);
        acquire(two,1);
    }

}
