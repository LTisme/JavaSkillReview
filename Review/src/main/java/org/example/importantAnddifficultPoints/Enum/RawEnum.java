package org.example.importantAnddifficultPoints.Enum;

/**
 * @Date: 2023/2/20
 * @Author: LTisme
 * @ClassName: RawEnum
 * @Description: ---> 产生枚举的最初想法重现，枚举类的字节码实现和下面的想法差不多
 */

public abstract class RawEnum {
    private int value;
    private String name;

    // 定义四个静态常量让每个季节在内存中独此一份
    public static final RawEnum SPRING = new RawEnum(1, "春天") {
        @Override
        public void sayHello() {
        }
    };
    public static final RawEnum SUMMER = new RawEnum(2, "夏天") {
        @Override
        public void sayHello() {

        }
    };
    public static final RawEnum AUTUMN = new RawEnum(3, "秋天") {
        @Override
        public void sayHello() {

        }
    };
    public static final RawEnum WINTER = new RawEnum(4, "冬天") {
        @Override
        public void sayHello() {

        }
    };

    private RawEnum(){}

    private RawEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void sayHello();
}
