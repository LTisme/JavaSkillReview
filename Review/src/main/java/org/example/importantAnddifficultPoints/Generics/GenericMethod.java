package org.example.importantAnddifficultPoints.Generics;

/**
 * @Date: 2023/2/13
 * @Author: LTisme
 * @ClassName: GenericMethod
 * @Description: ---> 泛型方法的写法当如是
 */

public class GenericMethod {

    public static <K, V> V show(K k, V v){
        System.out.println(k + " Inner " + v);
        return v;
    }

    public static void main(String[] args) {
        GenericMethod.show(1, "hi");
    }
}
