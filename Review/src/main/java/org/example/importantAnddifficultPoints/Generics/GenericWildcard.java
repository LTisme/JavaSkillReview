package org.example.importantAnddifficultPoints.Generics;

import org.example.littleProjectForPracticing.SuperArrayUsingGenerics.GenericSuperArray;
import org.example.littleProjectForPracticing.SuperArrayUsingGenerics.Super;

/**
 * @Date: 2023/2/14
 * @Author: LTisme
 * @ClassName: GenericWildcard
 * @Description: ---> 泛型通配符解释
 */

public class GenericWildcard {

    private class Animal{}

    private class Dog extends Animal{}

    private class Teddy extends Dog{}

//    // 无界通配符【注意】，泛型之间不能形成方法重载
//    public static void print(Super<?> superArr){
//        for (int i = 0; i < superArr.size(); i++) {
//            System.out.println(superArr.get(i));
//        }
//    }

//    // 上届通配符【注意】，泛型之间不能形成方法重载
//    public static void print(Super<? extends Animal> superArr){
//        for (int i = 0; i < superArr.size(); i++) {
//            System.out.println(superArr.get(i));
//        }
//    }

    // 下届通配符【注意】，泛型之间不能形成方法重载
    public static void print(Super<? super Dog> superArr){
        for (int i = 0; i < superArr.size(); i++) {
            System.out.println(superArr.get(i));
        }
    }


    public static void main(String[] args) {
        // 无界
//        GenericSuperArray<Object> genericSuperArray = new GenericSuperArray<>();

        // 上届
        GenericSuperArray<Dog> genericSuperArray = new GenericSuperArray<>();

        // 下届
        GenericSuperArray<Teddy> genericSuperArray2 = new GenericSuperArray<>();

        // 若使用下届，这里会出错
//        GenericWildcard.print(genericSuperArray2);
    }
}
