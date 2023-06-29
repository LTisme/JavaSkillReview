package org.example.algorithm;

import java.util.Random;

/**
 * @Date: 2022/12/25
 * @Author: LTisme
 * @ClassName: RandomArray
 * @Description: ---> 工具类，用来生成一个随机数组，可以指定数组的长度；
 *                    todo:暂时只生成整型的随机数组，后期复习泛型再把泛型的通用性加进去。
 */

public class RandomArray {

    private static final Random random = new Random();

    public static int[] GenerateNewRandomArray(int length, int bound){
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
