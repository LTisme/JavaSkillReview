package org.example.dataStructure.Tree.BinaryTree;

import java.util.ArrayDeque;

/**
 * @Date: 2023/3/7
 * @Author: LTisme
 * @ClassName: LevelTraversal
 * @Description: ---> 使用队列来实现层次遍历，很简单的
 */

public class LevelTraversal {
    private static class Node<T>{
        // 节点的数据
        T data;
        // 该节点还要有指向左孩子和右孩子的引用
        Node<T> left;
        Node<T> right;

        private Node(T data){
            this.data = data;
        }
    }

    private static <T> void LevelQueue(Node<T> node){
        System.out.println("------使用层次遍历遍历二叉树------");
        if (node != null){
            ArrayDeque<Node<T>> queue = new ArrayDeque<>();
            queue.add(node);
            Node<T> temp;
            while (!queue.isEmpty()){
                // 只当队列不空的时候出队
                temp = queue.poll();
                System.out.println(temp.data);
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 建立一个度数为3的二叉树
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);

        LevelQueue(root);
    }
}
