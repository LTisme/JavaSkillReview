package org.example.importantAnddifficultPoints;

/**
 * @Date: 2023/1/16
 * @Author: LTisme
 * @ClassName: AbstractAnimal
 * @Description: ---> 有抽象方法的类，必须被申明抽象类
 */

abstract class Creature{
    private String name = "Creature";

    public Creature(){
        System.out.println(name);
    }

    abstract void digest();
}

public class AbstractAnimal extends Creature{

    // 抽象类里的抽象方法只能用public 或者 protected 来修饰，如果不写，则默认是public 没有所谓的 default ，这点和接口中的抽象方法不一样
    public void digest(){
        System.out.println(this.getClass().getName() + " is digesting");
    }

    public static void main(String[] args) {
        AbstractAnimal animal = new AbstractAnimal();
        animal.digest();
    }
}
