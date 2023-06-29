package org.example.dataStructure;

import org.example.littleProjectForPracticing.SuperArray;

/**
 * @Date: 2023/1/5
 * @Author: LTisme
 * @ClassName: Stack
 * @Description: ---> 栈嘛，先进的元素后出嘛，很简单的
 */

public class Stack {
    private SuperArray superArray = new SuperArray();

    // 入栈的方法
    public void add(Integer item){
        superArray.add(item);
    }

    // 出栈的方法
    public Integer poll(){
        if(empty()){
            return null;
        }
        // 栈用数组维护的话，那取第一个数据就是最新入栈的数据，那就直接取
        Integer element = superArray.get(0);
        superArray.delete(0);
        return element;
    }

    // 返回队首，不出队
    public Integer peek(){
        if(empty()){
            return null;
        }
        return superArray.get(0);
    }

    // 判断这个队列是否为空
    public boolean empty(){
        return superArray.size() == 0;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
    }
}
