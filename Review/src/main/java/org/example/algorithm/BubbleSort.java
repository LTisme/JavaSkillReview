package org.example.algorithm;

import java.util.Arrays;

/**
 * @Date: 2022/12/20
 * @Author: LTisme
 * @ClassName: BubbleSort
 * @Description: ---> 自己完全按生硬的理解来写的冒泡，最简约的冒泡还是两次for，用i,j的巧妙互补就完成了。
 *                    最简约的冒泡排序写法写进了 bestSort()中。打算以后最简约的写法都写成 bestSort()好了，自己估摸着写就叫 sort()
 */

public class BubbleSort {
    // 执行冒泡排序
    public static void sort(int[] arr){
        // 正序，从下标为0的元素开始往后比较
        if (arr != null){
            int n = 0; // 冒泡需要多次冒泡，但每次冒泡会确定一个最大的数或者说是最小的数，这样每趟冒泡所遍历的个数就少一个
            while (n < arr.length){
                int temp;
                // 开始进行一次冒泡，还需要多次冒泡才能彻底完成，复杂度为O(n²)
                for (int i = 0; i < arr.length - 1 - n; i++) {
                    // 若start所指之数大于后面的数
                    if (arr[i] >= arr[i + 1]){
                        temp = arr[i + 1];
                        arr[i + 1] = arr[i];
                        arr[i] = temp;
                    }
                }
                n++;
            }
        }
    }

    public static void sort(int[] arr, boolean reverse){
        if (arr != null){
            // 判断是否要进行逆序排序
            if (!reverse){
                sort(arr);
                return;
            }
            int n = 0; // 冒泡需要多次冒泡，但每次冒泡会确定一个最大的数或者说是最小的数，这样每趟冒泡所遍历的个数就少一个
            while (n < arr.length){
                int temp;
                // 开始进行一次冒泡，还需要多次冒泡才能彻底完成，复杂度为O(n²)
                for (int i = 0; i < arr.length - 1 - n; i++) {
                    // 若start所指之数大于后面的数
                    if (arr[i] <= arr[i + 1]){
                        temp = arr[i + 1];
                        arr[i + 1] = arr[i];
                        arr[i] = temp;
                    }
                }
                n++;
            }
        }
    }

    public static void bestSort(int[] arr){
        if (arr != null){
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] >= arr[j + 1]){
                        int temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    public static void bestSort(int[] arr, boolean reverse){
        if (arr != null){
            if (!reverse){
                bestSort(arr);
                return;
            }
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] <= arr[j + 1]){
                        int temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = RandomArray.GenerateNewRandomArray(10, 100);
        System.out.println("Before BubbleSort: " + Arrays.toString(array));
        bestSort(array, true);
        System.out.println("After BubbleSort: " + Arrays.toString(array));
    }
}
