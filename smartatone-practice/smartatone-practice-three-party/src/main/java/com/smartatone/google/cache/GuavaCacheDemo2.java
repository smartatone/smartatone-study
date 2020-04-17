package com.smartatone.google.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 运行结果:
 *      null
 *      134
 *      45
 */
public class GuavaCacheDemo2 {

    static Cache<String, String> testCache = CacheBuilder.newBuilder().maximumSize(3).build();

    public static void main(String[] args) {
        testCache.put("1234", "45");

        System.out.println(testCache.getIfPresent("key6"));

        try {

            System.out.println(testCache.get("123", new Callable<String>() {
                public String call() throws Exception {
                    return "134";
                }
            }));

            System.out.println(testCache.get("1234", new Callable<String>() {
                public String call() throws Exception {
                    return "134";
                }
            }));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
