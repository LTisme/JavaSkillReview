package org.example.importantAnddifficultPoints.Generics;

/**
 * @Date: 2023/2/14
 * @Author: LTisme
 * @ClassName: GenericEraseExample1
 * @Description: ---> 为了兼容性，使用原始类型（没有类型参数的泛型）是合法的，泛型被添加进来时，还存在大量不使用泛型的代码。
 *                    为了保持这种兼容性，Java的泛型其实是一种伪泛型，这是因为Java在编译期间，所有的泛型信息都会被擦掉，正确理解泛型概念的首要前提是理解类型擦除。
 *                    Java的泛型基本上都是在编译器这个层次上实现的，在生成的字节码中是不包含泛型中的类型信息的，
 *                    使用泛型的时候加上类型参数，在编译器编译的时候会去掉，这个过程成为类型擦除。
 */

public class GenericEraseExample1<T>{

    private T value;

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }
}
