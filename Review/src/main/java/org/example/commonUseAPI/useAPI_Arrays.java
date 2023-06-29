package org.example.commonUseAPI;

import java.util.Arrays;

/**
 * @Date: 2023/2/12
 * @Author: LTisme
 * @ClassName: useAPI_Arrays
 * @Description: ---> Arrays 工具类有太多包装的方法了，toString、sort、equals、copyOf
 */

public class useAPI_Arrays {
    public static void main(String[] args) {
        int[] arr = {1, 2,3,4};
        // 不仅拷贝还能给你扩容
        int[] ints = Arrays.copyOf(arr, arr.length * 2);
        System.out.println(Arrays.toString(ints));
    }
}
