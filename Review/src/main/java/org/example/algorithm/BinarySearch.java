package org.example.algorithm;

import org.example.commonLogging.CommonLogger;

import java.util.Arrays;

/**
 * @Date: 2022/12/24
 * @Author: LTisme
 * @ClassName: BinarySearch
 * @Description: ---> 二分查找，也叫折半查找，它的前提条件是【必须有序！！！（正序、逆序无所谓）】
 *                    然后确定左右边界，接着再中间划一刀分两半；左半、右半又有新的左右边界，再中间划一刀，以此类推。
 *                    一直缩小范围到具体的某个符合查找条件的值。如果过程中出现左右边界重合，则说明没有目标内容。
 */

public class BinarySearch {

    private static final CommonLogger commonLogger = new CommonLogger();


    public static boolean search(int[] arr, int target){
        // 首先进行安全检测，值大于最大或小于最小的都不行，然后才在查找中通过左右边界是否重合来判断能否找到符合范围的值
        // 好的二分查找不用区分正序逆序都可以找
        int left = 0;
        int right = arr.length - 1;
        if (arr[0] <= arr[arr.length - 1]){
            // 说明是正序
            if (target < arr[0] || target > arr[arr.length - 1]){
//                System.out.println("目标值不在范围中，无法查找");
                commonLogger.PrintWarn("目标值不在范围中，无法查找");
                return false;
            }
            // 若是能通过安全检测，则进行二分查找
            while (left <= right){
                int mid = (left + right) / 2;
                if (arr[mid] < target){
                    // 说明中间值的右边一位应为新的左边界，右边界暂时不变
                    left = mid + 1;
                }
                else if (arr[mid] > target){
                    // 说明中间值的左边一位应为新的右边界，左边界暂时不变
                    right = mid - 1;
                }
                else {
                    // 说明arr[mid] == target，可以返回该值了
                    return true;
                }
            }
            // 遍历完了还没返回东西，说明查不到
            return false;
        }
        else {
            // 说明是逆序
            if (target < arr[arr.length - 1] || target > arr[0]){
                commonLogger.PrintWarn("目标值不在范围中，无法查找");
                return false;
            }
            // 若是能通过安全检测，则进行二分查找
            while (left <= right){
                int mid = (left + right) / 2;
                if (arr[mid] < target){
                    // 说明中间值的右边一位应为新的左边界，右边界暂时不变
                    right = mid - 1;
                }
                else if (arr[mid] > target){
                    // 说明中间值的左边一位应为新的右边界，左边界暂时不变
                    left = mid + 1;
                }
                else {
                    // 说明arr[mid] == target，可以返回该值了
                    return true;
                }
            }
            // 遍历完了还没返回东西，说明查不到
            return false;
        }

    }

    public static void main(String[] args) {
        int[] array = {92, 74, 56, 53, 50, 29, 25, 8, 7, 0};
        System.out.println("Array is : " + Arrays.toString(array));
        System.out.println("BinarySearch result is : " + BinarySearch.search(array, 100));
    }
}
