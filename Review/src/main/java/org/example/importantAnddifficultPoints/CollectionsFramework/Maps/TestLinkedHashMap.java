package org.example.importantAnddifficultPoints.CollectionsFramework.Maps;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Date: 2023/3/10
 * @Author: LTisme
 * @ClassName: TestLinkedHashMap
 * @Description: ---> LinkedHashMap 在原来的基础上维护了一个双向链表，用来维护，插入的顺序。
 *                    所以比起 HashMap 的乱序，LinkedHashMap 是有序的，
 */

public class TestLinkedHashMap {

    public static void main(String[] args){
        Map<String,String> map = new LinkedHashMap<>(16);
        map.put("m","abc");
        map.put("a","abc");
        map.put("g","bcd");
        map.put("s","cde");
        map.put("z","def");

        for (var next : map.entrySet()) {
            System.out.println("(" + next.getKey() + "," + next.getValue() + ")");
        }
    }
}
