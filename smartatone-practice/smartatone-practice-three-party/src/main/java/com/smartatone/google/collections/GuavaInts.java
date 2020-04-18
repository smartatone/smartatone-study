package com.smartatone.google.collections;

import java.util.List;

import com.google.common.primitives.Ints;

/**
 * @author xuyang001
 * @Description: GuavaInts
 * @create 2020-04-17 16:13
 **/
public class GuavaInts {

    public static void main(String[] args) {
        /**
         * 转换list
         * 执行结果:
         *      [1, 2, 3, 4]
         */
        List<Integer> list = Ints.asList(1, 2, 3, 4);
        System.out.println(list);

        /**
         * 拼接int
         * 执行结果:
         *      1,2,3,4
         */
        String str = Ints.join(",", 1, 2, 3, 4);
        System.out.println(str);

        /**
         * 多个数组合集
         * 执行结果:
         *      4
         */
        int[] newArray = Ints.concat(new int[] { 1, 2 }, new int[] { 2, 3 });
        System.out.println(newArray.length);

        /**
         * 最大最小值
         * 执行结果:
         *      3-1
         */
        System.out.println(Ints.max(newArray) + "-" + Ints.min(newArray));

        /**
         * 是否包含
         * 执行结果:
         *      true
         */
        System.out.println(Ints.contains(newArray, 1));

        /**
         * list转换数组
         * 执行结果:
         *  
         */
        System.out.println(Ints.toArray(list));
    }
}
