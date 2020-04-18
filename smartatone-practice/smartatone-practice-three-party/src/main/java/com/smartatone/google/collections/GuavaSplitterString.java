package com.smartatone.google.collections;

import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * @author xuyang001
 * @Description: splitter分隔操作
 * @create 2020-04-17 15:38
 **/
public class GuavaSplitterString {

    public static void main(String[] args) {
        String string = "1|2|3";

        /**
         * 分隔字符串成数组
         * 执行结果:
         *      [1, 2, 3]
         */
        System.out.println(Splitter.on("|").split(string));

        /**
         * 根据正则表达式分隔
         * 执行结果:
         *      [1, 2, 3]
         */
        System.out.println(Splitter.onPattern("\\s+").split("1 \t   2 3"));

        /**
         * 根据长度分隔
         * 执行结果:
         *      [1|, 2|, 3]
         */
        System.out.println(Splitter.fixedLength(2).split(string));

        /**
         * 分隔字符串成列表
         * 执行结果:
         *      [1, 2, 3]
         */
        Iterable<String> iterable = Splitter.on("|").split(string);
        List<String> list = Lists.newArrayList(iterable);
        System.out.println(list);

        /**
         * 分隔字符串成map
         * 执行结果:
         *      {1=2, 3=4}
         */
        System.out.println(Splitter.on("#").withKeyValueSeparator(":").split("1:2#3:4"));
    }
}
