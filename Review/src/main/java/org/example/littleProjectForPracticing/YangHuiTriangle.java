package org.example.littleProjectForPracticing;

import java.util.Arrays;

/**
 * @Date: 2022/12/25
 * @Author: LTisme
 * @ClassName: YangHuiTriangle
 * @Description: ---> 杨辉三角
 */

public class YangHuiTriangle {

    // 设定层数
    private static final int layers = 10;

    // 用二维数组来表示杨辉三角
    private static final int[][] YHTriangle;

    // 打印二维数组
    public static void PrintYHTriangle() {
        for (int[] ints : YHTriangle) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static {
        // 首先给第一维度初始化
        YHTriangle = new int[layers][];

        // 给二维数组的第二维度初始化，也就是指定长度
        for (int i = 0; i < YHTriangle.length; i++) {
            YHTriangle[i] = new int[i + 1];
        }

        // 第一步：把首、尾两个元素都是1给填进去
        for (int i = 0; i < YHTriangle.length; i++) {
            YHTriangle[i][0] = YHTriangle[i][YHTriangle[i].length - 1] = 1;
        }

        // 第二步，利用公式：n[i] = (n-1)[i-1]+(n-1)[i] 其中n代表层数，n≥3，i要剔除第一个和最后一个
        for (int n = 2; n < YHTriangle.length; n++) {
            for (int i = 1; i < YHTriangle[n].length - 1; i++) {
                YHTriangle[n][i] = YHTriangle[n - 1][i - 1] + YHTriangle[n - 1][i];
            }
        }
    }

    public static void main(String[] args) {
        YangHuiTriangle.PrintYHTriangle();
    }
}
