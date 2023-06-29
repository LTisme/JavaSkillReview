package org.example.commonUseAPI;

import java.math.BigDecimal;

/**
 * @Date: 2023/2/12
 * @Author: LTisme
 * @ClassName: useAPI_BigDecimal
 * @Description: ---> 0.1 或者 0.2 这种小数是无法用二进制精确表示的，只能接近但永远不能到达
 *                    不能直接用浮点来在Java中计算钱，必须得用BigDecimal，因为它使用了 IEEE 754 标准
 */

public class useAPI_BigDecimal {
    public static void main(String[] args) {
        System.out.println(0.1 + 0.2);

        // 看起来麻烦，但提供了基础的API之后就可以自己封装方法了
        BigDecimal num1 = new BigDecimal("0.1");
        BigDecimal num2 = new BigDecimal("0.2");
        System.out.println(num1.add(num2));
    }
}
