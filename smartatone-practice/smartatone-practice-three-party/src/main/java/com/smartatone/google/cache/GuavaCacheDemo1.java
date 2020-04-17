package com.smartatone.google.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.*;

/**
 * 执行结果:
 * [key0:value0] 被放入缓存!
 * [key1:value1] 被放入缓存!
 * [key2:value2] 被放入缓存!
 * [key3:value3] 被放入缓存!
 * [key4:value4] 被放入缓存!
 * [key5:value5] 被放入缓存!
 * [key6:value6] 被放入缓存!
 * [key0:value0] 被移除!
 * [key7:value7] 被放入缓存!
 * [key1:value1] 被移除!
 * [key8:value8] 被放入缓存!
 * [key2:value2] 被移除!
 * [key9:value9] 被放入缓存!
 * value6
 * null
 * com.google.common.cache.CacheLoader$InvalidCacheLoadException: CacheLoader returned null for key key.
 * 	at com.google.common.cache.LocalCache$Segment.getAndRecordStats(LocalCache.java:2350)
 * 	at com.google.common.cache.LocalCache$Segment.loadSync(LocalCache.java:2320)
 * 	at com.google.common.cache.LocalCache$Segment.lockedGetOrLoad(LocalCache.java:2282)
 * 	at com.google.common.cache.LocalCache$Segment.get(LocalCache.java:2197)
 * 	at com.google.common.cache.LocalCache.get(LocalCache.java:3937)
 * 	at com.google.common.cache.LocalCache.getOrLoad(LocalCache.java:3941)
 * 	at com.google.common.cache.LocalCache$LocalLoadingCache.get(LocalCache.java:4824)
 * 	at com.smartatone.google.cache.GuavaCacheDemo1.main(GuavaCacheDemo1.java:42)  
 */
public class GuavaCacheDemo1 {
    public static void main(String[] args) {
        //自定义loader
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            public String load(String key) throws Exception {
                Thread.sleep(1000);
                if ("key".equals(key)) {
                    return null;
                }
                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }
        };

        //缓存移除监听
        RemovalListener<String, String> removalListener = new RemovalListener<String, String>() {
            public void onRemoval(RemovalNotification<String, String> removal) {
                System.out.println("[" + removal.getKey() + ":" + removal.getValue() + "] 被移除!");
            }
        };

        LoadingCache<String, String> testCache = CacheBuilder.newBuilder().maximumSize(7) //最大条数
                .expireAfterWrite(10, TimeUnit.MINUTES) //最大时间
                .removalListener(removalListener).build(loader);

        for (int i = 0; i < 10; i++) {
            String key = "key" + i;
            String value = "value" + i;
            testCache.put(key, value);
            System.out.println("[" + key + ":" + value + "] 被放入缓存!");
        }

        System.out.println(testCache.getIfPresent("key6"));
        System.out.println(testCache.getIfPresent("key"));

        try {
            System.out.println(testCache.get("key"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
