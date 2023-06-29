package org.example.importantAnddifficultPoints;

/**
 * @Date: 2023/1/18
 * @Author: LTisme
 * @ClassName: AnonymousInnerClass
 * @Description: ---> 匿名内部类必须实现一个接口，或者继承一个父类；它的作用是那些只使用一次类的场景
 *                    注意点1：匿名内部类不能是抽象类，因为系统在创建匿名内部类时，会立即创建匿名内部类的对象。因此不允许。
 *                    注意点2：匿名内部类不能定义构造器，因为没有类名。但可以定义初始化块
 *                    注意点3：无法在匿名内部类中修改外部类的参数，匿名内部类中都是final的
 *
 *                    语法格式为：new 实现接口() | 父类构造器(实参列表)
 *                              {
 *                              // 匿名内部类的类体部分
 *                              }
 */

interface Product{
    double getPrice();
    String getName();
}

public class AnonymousInnerClass {
    public static void test(Product p){
        System.out.println("购买了一个" + p.getName() + "，花费了" + p.getPrice() + "元");
    }
    public static void main(String[] args) {
// 调用test方法时，需要传入一个Product参数，此处传入其匿名实现类的实例
        AnonymousInnerClass.test(new Product() {
            @Override
            public double getPrice() {
                return 567.8;
            }
            @Override
            public String getName() {
                return "AGP显卡";
            }
        });
    }
}
