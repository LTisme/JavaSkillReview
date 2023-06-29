package org.example.littleProjectForPracticing;

/**
 * @Date: 2023/1/4
 * @Author: LTisme
 * @ClassName: SuperLinkedList
 * @Description: ---> 这是超级链表，和数组一样都是线性表的数据结构，但链表在增、删的性能比数组要好；
 *                    在这里也只是简单地实现一下它的增删改查，也就是基本crud操作
 */



public class SuperLinkedList {

    private class Node{
        private Integer element;
        private Node next;

        public Node() {
        }

        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Integer getElement() {
            return element;
        }

        public void setElement(Integer element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Integer length = 0;

    public Integer size(){
        return length;
    }

    public Integer getHead(){
        return head.getElement();
    }

    // 尾插法，如果不维护一个尾部节点的话，尾插法的效率会低于头插法，因为每次都要定位到最后一个节点
    // TODO: 2023/1/5 以后可以维护一个尾部节点
    public void rearAdd(int element){
        if (head == null){
            head = new Node(element, null);
        } else {
            // 需要定位到最后一个节点，然后将新节点插入最后一个节点的后方
            Node currentNode = head;
            while (currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node(element, null));
        }
        length++;
    }

    // 增（头插法）
    public void headAdd(int element){
        if (head == null){
            head = new Node(element, null);
        } else {
            head = new Node(element, head);
        }
        length++;
    }

    @Override
    public String toString() {
        if (length <= 0){
            return null;
        }

        String temp = "[";

        Node currentNode = head;
        for (int i = 0; i < length; i++) {
            temp = temp + currentNode.getElement() + ",";
            currentNode = currentNode.getNext();
        }

        return temp.substring(0, temp.length() - 1) + "]";
    }

    // 删（删除下标为index的元素，首先判断它是否超出该链表的长度，而非超出长度后取模运算）
    public void delete(int index){
        if (index > length - 1 || index < 0){
            return;
        }
        if (index == 0){
            head = head.getNext();
        } else {
            // 将currentNode定位到要被删除的节点的前一个节点，然后开始删除
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
        }
        length--;
    }

    // 改
    public void update(int index, int element){
        if (index > length - 1 || index < 0){
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setElement(element);
    }

    // 查retrieve，
    public Integer retrieve(int target){
        if (length == 0){
            return null;
        }

        Node currentNode = head;
        for (int i = 0; i < length; i++) {
            if (currentNode.getElement() == target){
                return i;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    // 采用冒泡排序来给链表排序，不需要动引用，只用动其中的数据就可以了
    public void sort(){
        if (length <= 1){
            // 链表长度为0或者为1时，不需要排序
            return;
        }

        // 当length>=2时开始排序
        for (int i = 0; i < length - 1; i++) {
            Node currentNode = head;
            for (int j = 0; j < length - 1 - i; j++) {
                Node next = currentNode.getNext();
                if (currentNode.getElement() > next.getElement()){
                    int temp = next.getElement();
                    next.setElement(currentNode.getElement());
                    currentNode.setElement(temp);
                }
                currentNode = next;
            }
        }
    }

    public static void main(String[] args) {
        SuperLinkedList sl = new SuperLinkedList();
        sl.headAdd(1);
        sl.headAdd(2);
        sl.headAdd(3);
        sl.rearAdd(4);
        for (int i = 0; i < 10000; i++) {
            sl.headAdd((int) (Math.random() * 10000));
        }
//        System.out.println(sl.toString());
        long start = System.currentTimeMillis();
        sl.sort();
        long end = System.currentTimeMillis();
        System.out.println("耗时为：" + (end - start));
//        System.out.println(sl.toString());
//        sl.delete(1);
//        sl.delete(1);
//        System.out.println(sl.toString());
    }
}
