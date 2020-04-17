package com.smartatone.google.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 执行结果:
 *  java.lang.Object@2dda6444
 *  null
 *  CacheStats{hitCount=1, missCount=1, loadSuccessCount=0, loadExceptionCount=0, totalLoadTime=0, evictionCount=1}
 */
public class GuavaCacheDemo3 {

    static Cache<String, Object> testCache = CacheBuilder.newBuilder().weakValues().recordStats().build();

    public static void main(String[] args) {
        Object obj1 = new Object();
        testCache.put("1234", obj1);

        System.out.println(testCache.getIfPresent("1234"));

        obj1 = new String("123");
        System.gc();

        System.out.println(testCache.getIfPresent("1234"));
        System.out.println(testCache.stats());

    }
}
