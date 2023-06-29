package org.example.importantAnddifficultPoints;

/**
 * @Date: 2023/1/18
 * @Author: LTisme
 * @ClassName: LambdaExp
 * @Description: ---> Lambda 表达式只能替换函数式接口的匿名内部类写法
 */

@FunctionalInterface
interface Function{
    // 这就是函数式接口，它是个接口，但只有一个抽象方法
    int plus(int a, int b);
}

interface Function2 extends Function{
}

public class LambdaExp {

    public static void main(String[] args) {
        // 既可以用匿名内部类的方式来实现函数式接口
        Function function = new Function() {
            @Override
            public int plus(int a, int b) {
                return a + b;
            }
        };

        // 也可以像这样用lambda表达式来实现函数式接口，lambda的本质就是匿名内部类的优化版，是一种语法糖
        Function2 function2 = (i ,j) -> i + j;

        System.out.println("function.plus(1, 2) = " + function.plus(1, 2));
        System.out.println("function2.plus(3, 4) = " + function2.plus(3, 4));
    }
}
