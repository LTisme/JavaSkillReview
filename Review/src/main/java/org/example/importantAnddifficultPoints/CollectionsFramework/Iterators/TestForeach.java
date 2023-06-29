package org.example.importantAnddifficultPoints.CollectionsFramework.Iterators;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Date: 2023/3/9
 * @Author: LTisme
 * @ClassName: TestForeach
 * @Description: ---> forEach里的形参是个叫Consumer的泛型函数式接口，里面只有一个抽象方法accept
 */

public class TestForeach {
    public static void main(String[] args) {
        var hb = new HashMap<>();
        hb.put("1", "李明峰");
        hb.put("2", "歌特库");
        hb.put("3", "青年的");
        hb.put("4", "角门东");
        hb.put("5", "培育来");

        hb.forEach((i, j) -> {
            System.out.println("key: " + i + " val: " + j);
        });
    }
}
