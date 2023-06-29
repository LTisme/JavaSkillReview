package org.example.importantAnddifficultPoints;

/**
 * @Date: 2023/1/9
 * @Author: LTisme
 * @ClassName: PolymorphicAnimal
 * @Description: --->
 */
class Animal {
    public void eat(){
        System.out.println("animal is eating!");
    }
    public void eat(String food){
        System.out.println("animal is eating "+food);
    }
}

class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("dog is eating!");
    }

    @Override
    public void eat(String food) {
        System.out.println("dog is eating " + food);
    }
}

public class PolymorphicAnimal {
    public static void main(String[] args) {
        // 第一步是静态分派的过程，jvm从Animal类的多个重载方法中选择了 Animal::eat(String food) 这个方法，并且生成指令 invokevirtual Animal::eat(String food)。
        // 第二步是动态分派的过程，是根据运行时类型确定具体调用谁的 eat(String food) 方法，因为运行时类型是Dog，所以最终的方法选择是 Dog::eat(String food) 。
        Animal animal = new Dog();
        animal.eat("meat");
    }
}
