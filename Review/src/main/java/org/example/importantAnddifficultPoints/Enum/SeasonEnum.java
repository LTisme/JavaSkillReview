package org.example.importantAnddifficultPoints.Enum;

import java.util.Arrays;

/**
 * @Date: 2023/2/18
 * @Author: LTisme
 * @EnumClassName: SeasonEnum
 * @Description: --->
 *        方法	                       说明
 * values() 静态的自动生成的	可以遍历enum实例，其返回enum实例的数组
 * ordinal() 父类的实例方法	返回每个实例在声明时的次序
 * name() 父类的实例方法	    返回enum实例声明时的名称
 * getDeclaringClass()	    返回其所属的enum类
 * valueOf() 静态的自动生成的	根据给定的名称返回相应的enum实例
 *
 * 【而且枚举类里面可以添加抽象方法，变成抽象枚举类，那么抽象枚举类就不是被final修饰，可以被继承，而且不需要在抽象枚举类前面+abstract关键字，JVM会加的】
 * 【枚举实例常量若想能有独立的实例方法，就得通过实现抽象方法。可以用接口，也可以在枚举类中加入抽象方法】
 */

public enum SeasonEnum {
    SPRING("春天来了", "又到了万物生长的环节"){
        public void sayHello(){
            System.out.println("hello");
        }
    };
//    SUMMER("夏天","热的要命，但是小姐姐都穿短裤"),
//    AUTUMN("秋天","是到了收获的季节"),
//    WINTER;

    // 枚举类的实例还可以自定义初始化值
    private String name;
    private String detail;

    private SeasonEnum(){

    }

    private SeasonEnum(String name, String detail){
        this.name = name;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    // 如果少了这个抽象方法，则无法使实例枚举量调用这个方法，至于为什么可以去看同一个包下的RawEnum，就像一个匿名内部类
    // 若是不需要每个枚举实例常量都有不同的输出，则可以把抽象方法定义成接口，让枚举类实现该接口
    public abstract void sayHello();

    public static void main(String[] args) {
        // 静态方法values是用来遍历枚举类的
        System.out.println(Arrays.toString(SeasonEnum.values()));
        //
        System.out.println(SeasonEnum.valueOf("SPRING"));

        //
        SeasonEnum spring = SeasonEnum.SPRING;
        spring.sayHello();

    }
}
