package org.example.littleProjectForPracticing.SuperArrayUsingGenerics;

/**
 * @Date: 2023/2/13
 * @Author: LTisme
 * @ClassName: GenericSuperLinkedList
 * @Description: --->
 */

public class GenericSuperLinkedList<T> implements Super<T>{
    private class Node{
        private T element;
        private Node next;

        public Node() {
        }

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
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


    public T getHead(){
        return head.getElement();
    }

    @Override
    public void add(T element) {
        // 使用头插法
        if (head == null){
            head = new Node(element, null);
        } else {
            head = new Node(element, head);
        }
        length++;
    }

    @Override
    public void delete(int index) {
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

    @Override
    public void update(int index, T element) {
        if (index > length - 1 || index < 0){
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setElement(element);
    }

    @Override
    public Integer retrieve(T target) {
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

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public Integer size() {
        return length;
    }

    @Override
    public void printSelf() {
        System.out.println(this);
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

    public static void main(String[] args) {
        Super<Integer> superLinkedList = new GenericSuperLinkedList<>();
        superLinkedList.add(1);
        superLinkedList.add(2);
        superLinkedList.add(3);
        superLinkedList.add(4);
        for (int i = 0; i < 10000; i++) {
            superLinkedList.add((int) (Math.random() * 10000));
        }
        superLinkedList.printSelf();
    }
}
