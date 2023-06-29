package org.example.importantAnddifficultPoints.Generics;

import java.util.Arrays;

/**
 * @Date: 2023/2/13
 * @Author: LTisme
 * @ClassName: GenericSuperArray
 * @Description: ---> 1、什么是泛型？看表面的意思，泛型就是指广泛的、普通的类型。泛型能够帮助我们把【类型明确】的工作推迟到创建对象或调用方法的时候。
 *                    意思就是：我定义类的时候不用管到底是什么类型，new 这个对象或者调用这个对象的方法时才确定具体的类型。
 *                    2、这里的是泛型类，就是把泛型定义在类上，而非生成一个独特的类，当然还有泛型方法，请看 GenericMethod
 */

public class GenericSuperArray<T> {
    private Object[] arr;

    // 用来维护数组目前到哪里的下标
    private int currentIndex = -1;

    public GenericSuperArray(){
        this(10);
    }
    public GenericSuperArray(int capacity){
        this.arr = new Object[capacity];
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

    public int size(){
        return arr.length;
    }

    public void printSuperArray(){
        System.out.println(Arrays.toString(this.arr));
    }

    public static void main(String[] args) {
        int[] array = {92, 74, 56, 53, 50, 29, 25, 8, 7, 0};
        double[] array2 = {92.1, 74.2, 56, 53, 50, 29, 25, 8.7, 7, 0};
        GenericSuperArray<Integer> superArray = new GenericSuperArray<>();
        GenericSuperArray<Double> superArray2 = new GenericSuperArray<>();
        superArray2.printSuperArray();
        for (double j : array2) {
            superArray2.add(j);
        }
        superArray2.printSuperArray();
        superArray2.delete(3);
        superArray2.delete(3);
        superArray2.add(111.2);
        superArray2.add(777.3);
        superArray2.update(0, 999.9);
        System.out.println("查找25的结果是：" + superArray2.retrieve(74.2));
        superArray2.printSuperArray();
    }
}
