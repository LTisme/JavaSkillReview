package org.example.dataStructure;

import org.example.littleProjectForPracticing.SuperLinkedList;

/**
 * @Date: 2023/1/5
 * @Author: LTisme
 * @ClassName: Queue
 * @Description: ---> 队列嘛，先进的元素先出嘛，很简单的
 */

public class Queue {
    private SuperLinkedList sll = new SuperLinkedList();

    // 入队的方法，队列是先进先出，用尾插法，每次只用取头节点元素，就是取最先入队的元素
    public void add(Integer item){
        sll.rearAdd(item);
    }

    // 出队的方法
    public Integer poll(){
        if(empty()){
            return null;
        }
        // 队列的头一定是最先入队的元素
        Integer element = sll.getHead();
        sll.delete(0);
        return element;
    }

    // 返回队首，不出队
    public Integer peek(){
        if(empty()){
            return null;
        }
        return sll.getHead();
    }

    // 判断这个队列是否为空
    public boolean empty(){
        return sll.size() == 0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
