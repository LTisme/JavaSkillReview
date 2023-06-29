package org.example.dataStructure.Tree.BinaryTree;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Date: 2023/3/3
 * @Author: LTisme
 * @ClassName: StackTraversal
 * @Description: ---> 使用栈来实现前中后序遍历，在于如何使用栈这种线性结构来压栈出栈树
 *                    【前序遍历】的难点，有两个关键点：
 *                    ① 保存根树节点的引用，这样才能获得左右子树
 *                    ② 先压栈右子树，再压栈左子树，这样弹栈的时候，会先弹左子树
 *                    【中序遍历】的难点，有两个关键点：
 *                    ① 保存根树节点的引用，这样才能获得左右子树
 *                    ② 先压栈右子树，再压栈左子树，这样弹栈的时候，会先弹左子树
 *                    【后序遍历】是最难的，需要用到两个栈，当然单栈实现的方法也有
 *                    将1栈弹出元素压入2栈，2栈依次弹出便可以达到后序遍历效果
 *                    1栈的作用就是帮2栈回溯上一个节点用的，而不破坏2栈达到想要的顺序
 */

public class StackTraversal {
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

    private static <T> void PreorderStack(Node<T> node){
        System.out.println("-------先序遍历------");
        // 使用Java自带的Stack包
        if (node != null){
            Stack<Node<T>> stack = new Stack<>();
            stack.add(node);
            // 只要栈不空，就要弹栈
            while (!stack.isEmpty()){
                node = stack.pop();
                System.out.println(node.data);
                if (node.right != null){
                    stack.add(node.right);
                }
                if (node.left != null){
                    stack.add(node.left);
                }
            }
        }
    }

    private static <T> void InorderStack(Node<T> node){
        System.out.println("-------中序遍历------");
        // 思路是：当前节点先入栈，然后再判断它的左孩子是否为空，不为空则继续入栈，并将引用指向左孩子；
        // 若左孩子为空，则直接弹栈，再判断右孩子是否为空……
        if (node != null){
            Stack<Node<T>> stack = new Stack<>();

            Node<T> temp = node;
            while (!stack.isEmpty() || temp != null){
                if (temp != null){
                    // 将temp引用入栈后，立即将temp引用指向当前引用的左孩子
                    stack.add(temp);
                    temp = temp.left;
                } else {
                    // 只要左孩子为空，就直接弹栈，
                    temp = stack.pop();
                    System.out.println(temp.data);
                    temp = temp.right;
                }
            }
        }
    }

    private static <T> void PostorderStack(Node<T> node){
        System.out.println("-------后序遍历------");
        if (node != null) {
            Stack<Node<T>> stack1 = new Stack<>();
            Stack<Node<T>> stack2 = new Stack<>();

            Node<T> temp = node;
            while (!stack1.isEmpty() || temp != null){
                if (temp != null){
                    stack1.add(temp);
                    stack2.add(temp);
                    temp = temp.right;
                } else {
                    temp = stack1.pop();
                    temp = temp.left;
                }
            }

            // 最后打印辅助栈
            while (!stack2.isEmpty()){
                System.out.println(stack2.pop().data);
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

//        PreorderStack(root);
//        InorderStack(root);
        PostorderStack(root);
    }
}
