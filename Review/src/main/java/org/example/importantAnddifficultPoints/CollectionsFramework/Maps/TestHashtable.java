package org.example.importantAnddifficultPoints.CollectionsFramework.Maps;

import java.util.Hashtable;
import java.util.Map;

/**
 * @Date: 2023/3/11
 * @Author: LTisme
 * @ClassName: TestHashtable
 * @Description: ---> HashMap和HashTable区别:
 *                    HashMap允许将 null 作为一个 entry 的 key 或者 value，而 Hashtable 不允许。
 *                    HashMap 把 Hashtable 的 contains 方法去掉了，改成 containsValue 和 containsKey。因为 contains 方法容易让人引起误解。
 *                    HashTable 继承自 Dictionary 类，而 HashMap 是 Java1.2 引进的 Map interface 的一个实现。
 *                    HashTable 的方法是 Synchronized修饰 的，而 HashMap 不是，这也是是否能保证线程安全的重要保障。
 *                    Hashtable 和 HashMap 采用的 hash/rehash 算法都不一样。
 *                    获取数组下标的算法不同（int index = (hash & 0x7FFFFFFF) % tab.length;），
 */

public class TestHashtable {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, String> ht = new Hashtable<>();

        // 10个添加，5个删
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(() -> {
                ht.put(finalI, "This is " + finalI);
            }).start();
        }
        Thread.sleep(1000);

        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            new Thread(() -> {
                ht.remove(finalI);
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(ht);
    }
}
