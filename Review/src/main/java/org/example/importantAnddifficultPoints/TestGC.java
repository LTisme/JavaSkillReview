package org.example.importantAnddifficultPoints;

/**
 * @Date: 2023/1/19
 * @Author: LTisme
 * @ClassName: TestGC
 * @Description: --->
 */

public class TestGC {
    public static void main(String[] args) {
        byte[] arr1 = new byte[1024 * 1024];
        byte[] arr2 = new byte[1024 * 1024];
        byte[] arr3 = new byte[1024 * 1024];
        byte[] arr4 = new byte[1024 * 1024];
        byte[] arr5 = new byte[1024 * 1024];
        arr1 = null;
        arr2 = null;
        arr3 = null;
        arr4 = null;
    }
}
