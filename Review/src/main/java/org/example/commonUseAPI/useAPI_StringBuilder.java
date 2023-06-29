package org.example.commonUseAPI;

/**
 * @Date: 2023/2/12
 * @Author: LTisme
 * @ClassName: useAPI_StringBuilder
 * @Description: ---> 1.先说为什么要用StringBuilder， 因为 String 对象是不可变的，而我们常常要做字符串修改、拼接
 *                    2.StringBuilder和StringBuffer用法和功能相同，但 StringBuilder 线程不安全，性能高；StringBuffer 线程安全，性能低
 */

public class useAPI_StringBuilder {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000000; i++) {
            stringBuilder.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10000000; i++) {
            stringBuffer.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
