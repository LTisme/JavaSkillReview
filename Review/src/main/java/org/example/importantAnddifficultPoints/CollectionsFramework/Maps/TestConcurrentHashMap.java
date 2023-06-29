package org.example.importantAnddifficultPoints.CollectionsFramework.Maps;

/**
 * @Date: 2023/3/11
 * @Author: LTisme
 * @ClassName: TestConcurrentHashMap
 * @Description: ---> ConcurrentHashMap 这个是重点，很重要！！！
 *                    1.8中的 ConcurrentHashMap和 HashMap的代码基本一样，只不过在有些操作上使用了CAS，有些地方加了锁。
 *                    因为 HashMap 的结构是这样的，所以在线性表中冲突后往下挂链表，那么多线程往同一个位置上插入内容时，只有最后一个线程的操作有效，
 *                    所以 ConcurrentHashMap 做的就是锁住表头节点，从而避免冲突，而因为冲突发生的概率小，所以它的效率还是很高的
 *                    🛑 🛑 🛑 🛑 🛑 🛑 🛑 🛑 🛑 🛑
 *                    ↓   ↓  ↓     ↓   ↓  ↓  ↓  ↓  ↓
 *                    ⏹ ⏹ ⏹    ⏹ ⏹ ⏹ ⏹ ⏹ ⏹
 *                    ↓      ↓     ↓   ↓  ↓
 *                    ⏹    ⏹    ⏹ ⏹ ⏹
 *                    ↓      ↓     ↓   ↓
 *                    ⏹    ⏹    ⏹ ⏹
 *                           ↓
 *                          ⏹
 *
 *                    其实，面试不仅会问 ConcurrentHashMap ，也很喜欢问 HashMap的1.7和1.8的区别:
 *                    主要是JDK1.7的分段锁是一个很经典的案例，造成这个的原因还有一个更重要的就是JDK1.7使用的是头插，而1.8改成尾插
 *                    由于JDK1.7的HashMap是头插的，所以 JDK1.7 的 ConcurrentHashMap 的加锁是用分段锁实现的（不能锁表头，因为表头一直在变）
 */

public class TestConcurrentHashMap {
}
