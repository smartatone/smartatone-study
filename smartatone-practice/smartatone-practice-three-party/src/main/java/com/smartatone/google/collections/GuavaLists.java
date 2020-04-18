package com.smartatone.google.collections;

import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GuavaLists {

    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3 };
        String join = Joiner.on(",").join(intArray);
        System.out.println(join);
        guavaNewList();
        guavaConcatList();
    }

    //新的list
    static void guavaNewList() {
        List<String> list = Lists.newArrayList();
        list.add("1");
        System.out.println("newList:" + list);
        list = Lists.newArrayList("1", "2", "3");
        System.out.println("newList:" + list);
    }

    //串联多个list
    static void guavaConcatList() {
        List<String> list = Lists.newArrayList("1", "2");
        List<String> list1 = Lists.newArrayList("2", "3", "4");
        list.retainAll(list1);
        System.out.println(list);

        Map<String, String> map = Maps.newHashMap();
        map.put("1", "1");
        Map<String, String> map2 = Maps.newHashMap();
        map.put("2", "2");
    }
}
