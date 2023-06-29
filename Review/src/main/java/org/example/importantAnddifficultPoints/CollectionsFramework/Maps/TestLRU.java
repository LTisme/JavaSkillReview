package org.example.importantAnddifficultPoints.CollectionsFramework.Maps;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Date: 2023/3/10
 * @Author: LTisme
 * @ClassName: TestLRU
 * @Description: ---> 而且它还能实现LRU算法，LRU:Least Recently Used,最近最少使用,即当缓存了,会优先淘汰那些最近不常访问的数据.即冷门数据优先淘汰
 *                    若要更加精细的定义 LRU，比如删除最冷门的数据，则要去实现里面被 protected 修饰的 removeEldestEntry()方法
 */

public class TestLRU<K, V> extends LinkedHashMap<K, V>{

    public TestLRU(int initialCapacity) {
        super(initialCapacity, 0.75F, true);
    }

    public TestLRU() {
        super(16, 0.75F, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//        return super.removeEldestEntry(eldest);
        // 如果返回 true 就是删除冷门数据，所以这里就是在做何时删除冷门数据
        return size() > 3;
    }

    public static void main(String[] args) {
        Map<String, String> lru = new TestLRU<>();
        lru.put("m","abc");
        lru.put("a","abc");
        lru.put("g","bcd");
        lru.get("m");
        lru.put("s","cde");
        lru.put("z","def");

        System.out.println(lru);
    }
}
