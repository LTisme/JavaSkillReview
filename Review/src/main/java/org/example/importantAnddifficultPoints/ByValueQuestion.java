package org.example.importantAnddifficultPoints;

/**
 * @Date: 2023/1/18
 * @Author: LTisme
 * @ClassName: ByValueQuestion
 * @Description: ---> Java 当中的值传递问题，其实每种语言都一样的 《Python 学习手册》讲得更好，方法内的局部变量并不能影响外部
 *                    其实方法一结束，里面的局部变量没被返回出去的话就会被回收
 */

public class ByValueQuestion {

    private static int num = 5;
    private static String str = "你好";

    private static int[] arr = new int[2];

    public static void ChangeNum(int num){
        num = 10;
    }

    public static void ChangeString(String str){
        str = "hello";
    }
    public static void ChangeArray(int[] arr){
        arr = new int[5];
    }
    public static void main(String[] args) {
        ByValueQuestion.ChangeNum(num);
        System.out.println(num);

        ByValueQuestion.ChangeString(str);
        System.out.println(str);

        System.out.println(arr);
        ByValueQuestion.ChangeArray(arr);
        System.out.println(arr);
    }
}
