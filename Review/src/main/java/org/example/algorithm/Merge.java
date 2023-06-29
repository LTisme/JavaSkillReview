package org.example.algorithm;

import java.util.Arrays;

/**
 * @Date: 2022/12/25
 * @Author: LTisme
 * @ClassName: Merge
 * @Description: --->归并（合并），而非归并排序，但是和归并排序的思想是一致的，他需要两个有序的数组，数组长度可以不一样
 *                   然后合并成一条新的有序数组
 */

public class Merge {

    public static int[] merge(int[] arr1, int[] arr2){
        // 这里先不管是否有序的安全检测，直接开始归并，先做正序的归并
        int[] targetArr = new int[arr1.length + arr2.length];
        int i = 0, j =0;

        // ✳开始打擂台✳
        for (int k = 0; k < targetArr.length; k++) {
            if (i != arr1.length && j != arr2.length){
                if (arr1[i] >= arr2[j]){
                    targetArr[k] = arr2[j++];
                } else if (arr1[i] < arr2[j]) {
                    targetArr[k] = arr1[i++];
                }
                continue;
            }
            //
            if (i != arr1.length){
                targetArr[k] = arr1[i++];
            }
            if (j != arr2.length){
                targetArr[k] = arr2[j++];
            }
        }
        return targetArr;
    }

    public static void main(String[] args) {
        int[] arr1 = RandomArray.GenerateNewRandomArray(11, 100);
        int[] arr2 = RandomArray.GenerateNewRandomArray(3, 100);
        BubbleSort.bestSort(arr1);
        BubbleSort.bestSort(arr2);
        String format = String.format("Before Merge:\n arr1 is : %s\n arr2 is : %s", Arrays.toString(arr1), Arrays.toString(arr2));
        System.out.println(format);
        System.out.println("-------------------");
        System.out.println("After Merge is : " + Arrays.toString(Merge.merge(arr1, arr2)));
    }
}
