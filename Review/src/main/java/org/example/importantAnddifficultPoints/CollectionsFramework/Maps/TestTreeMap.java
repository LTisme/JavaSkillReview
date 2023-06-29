package org.example.importantAnddifficultPoints.CollectionsFramework.Maps;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Date: 2023/3/10
 * @Author: LTisme
 * @ClassName: TestTreeMap
 * @Description: ---> TreeMap底层实现是红黑树，所以天然支持排序。
 *                    如果对象的排序需要基于自然顺序，请选择实现 Comparable 接口
 *                    如果需要按照对象的不同属性进行排序，请选择实现 Comparator 接口。采用定制排序时，不要求Map的key实现Comparable接口。
 */

public class TestTreeMap {
    private static class Paper{
        private String TYPE;

        private int size;

        public Paper() {
            TYPE = "A";
            size = 4;
        }

        public Paper(String TYPE, int size) {
            this.TYPE = TYPE;
            this.size = size;
        }

        public String getTYPE() {
            return TYPE;
        }

        public void setTYPE(String TYPE) {
            this.TYPE = TYPE;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return TYPE + size;
        }
    }

    public static void main(String[] args) {
        // TreeMap，如果不传入一个Comparator就默认类型已经实现了Comparable接口，
        // 而且TreeMap在put的时候才调用compare方法，如果你没有在Treemap中传入Comparator的实现，而且类没有实现Comparable接口，就会
//        Map<String, String> treemap = new TreeMap<>();
//        treemap.put("z", "zeeker");
//        treemap.put("h", "hunter");
//        treemap.put("d", "dunk");
//        treemap.put("x", "xanadu");
//        treemap.put("a", "apple");
//
//        // 它会按照字典序排列
//        System.out.println(treemap);


        // ---------------------------------------
        // 可能好奇Comparator接口中，boolean equals() 不也是抽象方法吗，那compare也是抽象方法，为什么就算函数式接口了？
        // 因为在注解@FuctionalInterface（自动检测是否为函数式接口）的javadoc中说明了，如果接口重写了Object的公共方法不算入内
        Map<Paper, String> tp = new TreeMap<>(new Comparator<Paper>() {
            @Override
            public int compare(Paper o1, Paper o2) {
                // 因为String已经实现Comparable接口中的compareTo方法，所以可以这样调用
                return o1.getTYPE().compareTo(o2.getTYPE());
            }
        });
        tp.put(new Paper("B", 5), "这是B5");
        tp.put(new Paper("A", 4), "这是A4");
        tp.put(new Paper("Z", 2), "这是Z2");
        tp.put(new Paper("C", 4), "这是C4");

        System.out.println(tp);
    }
}
