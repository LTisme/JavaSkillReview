package org.example.littleProjectForPracticing;

import java.util.Arrays;

/**
 * @Date: 2022/12/26
 * @Author: LTisme
 * @ClassName: SuperArray
 * @Description: ---> 说是超级数组其实就是基本crud的数组，可以实现自动扩容和安全检测；
 *                    暂时只用整型来表示
 */

public class SuperArray {

    private Integer[] arr;

    // 用来维护数组目前到哪里的下标
    private int currentIndex = -1;

    public SuperArray(){
        this(10);
    }
    public SuperArray(int capacity){
        this.arr = new Integer[capacity];
    }

    // 增
    public void add(int element){
        // 添加元素的方法应该能实现自动扩容，而且在数组刚初始化，还没元素的时候不会
        // 所以要先进行越界判定，如果越界就进行扩容处理
        if (++currentIndex > arr.length - 1) {
            // 进行扩容
            Integer[] temp = new Integer[arr.length * 2];
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
    public void update(int index, int element){
        if (index >= 0 && index <= (arr.length - 1)){
            arr[index] = element;
        }
    }

    // 查retrieve，
    public Integer retrieve(int target){
        // 输入一个目标，查看是否有该数并返回它在数组中的下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                return i;
            }
        }
        return null;
    }

    // 获得任意符合要求的index的元素
    public Integer get(int index){
        if (arr.length == 0){
            return null;
        }
        if (index >= 0 && index < arr.length){
            return arr[index];
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
        SuperArray superArray = new SuperArray();
        superArray.printSuperArray();
        for (int j : array) {
            superArray.add(j);
        }
        superArray.printSuperArray();
        superArray.delete(3);
        superArray.delete(3);
        superArray.add(111);
        superArray.add(777);
        superArray.update(0, 999);
        System.out.println("查找25的结果是：" + superArray.retrieve(25));
        superArray.printSuperArray();
    }
}
