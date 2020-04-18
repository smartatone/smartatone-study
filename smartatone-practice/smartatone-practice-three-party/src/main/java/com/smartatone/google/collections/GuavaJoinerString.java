package com.smartatone.google.collections;

import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * @author xuyang001
 * @Description: Guava string 操作
 * @create 2020-04-17 15:13
 **/
public class GuavaJoinerString {
    public static void main(String[] args) {
        String[] strArray = { "1", "2", "3" };

        /**
         * 拼接数组
         * 输出结果:
         *      1,2,3
         */
        System.out.println(Joiner.on(",").join(strArray));
        /**
         * 拼接字符串
         * 输出结果:
         *      1,2,3
         */
        System.out.println(Joiner.on(",").join("1", "2", "3"));

        /**
         * 拼接stringBuffer
         * 输出结果:
         *      result:1,2,3
         */
        StringBuilder sb = new StringBuilder("result:");
        System.out.println(Joiner.on(",").appendTo(sb, 1, 2, 3));

        /**
         * 拼接stringBuffer
         * 输出结果:
         *      result:1。2。3
         */
        sb = new StringBuilder("result:");
        System.out.println(Joiner.on("。").appendTo(sb, strArray));

        /**
         * 拼接忽略null
         * 输出结果:
         *      1 3
         *      1 None 3
         */
        System.out.println(Joiner.on(' ').skipNulls().join(1, null, 3));

        /**
         * 拼接map
         * 输出结果:
         *      key1=value1#key2=value2
         */
        Map<String, String> map = Maps.newHashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        System.out.println(Joiner.on("#").withKeyValueSeparator("=").join(map));

        /**
         * 拼接map
         * 输出结果:
         *      1=2#3=4
         */
        System.out.println(Joiner.on("#").withKeyValueSeparator("=").join(ImmutableMap.of(1, 2, 3, 4)));
    }
}
