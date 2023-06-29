package org.example.littleProjectForPracticing.SuperArrayUsingGenerics;

import java.util.Arrays;

/**
 * @Date: 2023/2/13
 * @Author: LTisme
 * @ClassName: GenericSuperArray
 * @Description: --->
 */

// 实现泛型接口的写法如下
public class GenericSuperArray<T> implements Super<T>{
    private Object[] arr;

    // 用来维护数组目前到哪里的下标
    private int currentIndex = -1;

    public GenericSuperArray(){
        this(10);
    }
    public GenericSuperArray(int capacity){
        this.arr = new Integer[capacity];
    }

    // 增
    public void add(T element){
        // 添加元素的方法应该能实现自动扩容，而且在数组刚初始化，还没元素的时候不会
        // 所以要先进行越界判定，如果越界就进行扩容处理
        if (++currentIndex > arr.length - 1) {
            // 进行扩容
            Object[] temp = new Object[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        arr[currentIndex] = element;
    }

    // 删，从中间删的话就得让后面的元素一个个地往前贴
    public void delete(int index){
        if (index >= 0 && index <= (arr.length - 1)){
            for (int i = index + 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
        }
    }

    // 改
    public void update(int index, T element){
        if (index >= 0 && index <= (arr.length - 1)){
            arr[index] = element;
        }
    }


    // 查retrieve，
    public Integer retrieve(T target){
        // 输入一个目标，查看是否有该数并返回它在数组中的下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                return i;
            }
        }
        return null;
    }

    // 获得任意符合要求的index的元素
    public T get(int index){
        if (arr.length == 0){
            return null;
        }
        if (index >= 0 && index < arr.length){
            return (T)arr[index];
        }
        return null;
    }

    public Integer size(){
        return arr.length;
    }

    @Override
    public void printSelf() {
        System.out.println(Arrays.toString(this.arr));
    }

    public static void main(String[] args) {
        Super<Integer> array = new GenericSuperArray<>();
        int[] arr = {92, 74, 56, 53, 50, 29, 25, 8, 7, 0};
        array.printSelf();
        for (int j : arr) {
            array.add(j);
        }
        array.printSelf();
        array.delete(3);
        array.delete(3);
        array.add(111);
        array.add(777);
        array.update(0, 999);
        System.out.println("查找25的结果是：" + array.retrieve(25));
        array.printSelf();
    }
}
