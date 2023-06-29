package org.example.importantAnddifficultPoints.Generics;

/**
 * @Date: 2023/2/14
 * @Author: LTisme
 * @ClassName: GenericMethod2
 * @Description: ---> 泛型实例方法1
 */

public class GenericMethod1<T> {

    private T value;

    public T getValue(){
        return value;
    }

    public static <T> T judge(T t){
        if (t instanceof String){
            return t;
        }
        else return null;
    }

    public static void main(String[] args) {
        GenericMethod1<Integer> objectGenericMethod2 = new GenericMethod1<>();
        Integer value1 = objectGenericMethod2.getValue();
        System.out.println(value1);
    }
}
