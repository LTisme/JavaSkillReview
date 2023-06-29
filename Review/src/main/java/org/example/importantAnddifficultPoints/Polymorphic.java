package org.example.importantAnddifficultPoints;

/**
 * @Date: 2023/1/5
 * @Author: LTisme
 * @ClassName: Polymorphic
 * @Description: ---> 多态性的研究
 */
class Father{
    public String name = Father.class.getName();

    public void normalMethod(){
        System.out.println("Father's Method");
    }
}

class Son extends Father{
    public String name = Son.class.getName();

    public void normalMethod(){
        System.out.println("Son's Method");
    }

    public void OnlySon(){
        System.out.println("Son's special Method");
    }
}

public class Polymorphic {
    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        Father poly = new Son();

        System.out.println(father.name);
        System.out.println(son.name);
        // 多态发生了
        System.out.println(poly.name + "\n");

        father.normalMethod();
        son.normalMethod();
        poly.normalMethod();
        // 下面的方法为什么不行？因为这已经不是重写了，不符合多态的要求，
//        poly.OnlySon();
        // 所以得转成相应类型才能正常运行
        ((Son)poly).OnlySon();
    }
}
