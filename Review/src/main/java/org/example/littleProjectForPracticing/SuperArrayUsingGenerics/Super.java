package org.example.littleProjectForPracticing.SuperArrayUsingGenerics;

import java.util.Arrays;

/**
 * @Date: 2023/2/13
 * @Author: LTisme
 * @InterfaceName: Super
 * @Description: ---> 将超级数组和超级列表的方法通过泛型抽象出一堆的抽象方法
 */

public interface Super<T> {

    // 增
    void add(T element);

    // 删，从中间删的话就得让后面的元素一个个地往前贴
    void delete(int index);

    // 改
    void update(int index, T element);

    // 查retrieve，并返回接口
    Integer retrieve(T target);

    // 获得任意符合要求的index的元素
    T get(int index);

    // 获得长度
    Integer size();

    // 打印
    void printSelf();
}
