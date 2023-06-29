package org.example.designPattern.StrategyMethod.verygood;

/**
 * @Date: 2023/2/14
 * @Author: LTisme
 * @InterfaceName: Comparable
 * @Description: ---> 这种用泛型写成的策略模式，会更加通用，可以满足各种类型的比较
 */

public interface Comparable<T> {
    boolean compare(T o1, T o2);
}
