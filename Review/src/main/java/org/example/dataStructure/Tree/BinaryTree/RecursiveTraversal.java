package org.example.dataStructure.Tree.BinaryTree;

/**
 * @Date: 2023/3/3
 * @Author: LTisme
 * @ClassName: PreorderTraversal
 * @Description: ---> 使用递归方法进行前中后序遍历的实现
 */

public class RecursiveTraversal {

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

    // 递归方法，无论是前序、中序、后序遍历都是要进行的，而且都是先根节点，再左孩子节点，再右孩子节点
    private static <T> void PreorderRecursive(Node<T> node){
        // 递归方法一定要有合适的退出机制
        if (node == null){
            return;
        }
        System.out.println(node.data);
        PreorderRecursive(node.left);
        PreorderRecursive(node.right);
    }

    // 中序遍历，第二次到该节点时
    private static <T> void InorderRecursive(Node<T> node){
        // 递归方法一定要有合适的退出机制
        if (node == null){
            return;
        }
        InorderRecursive(node.left);
        System.out.println(node.data);
        InorderRecursive(node.right);
    }

    // 后序遍历，第三次到该节点时
    private static <T> void PostorderRecursive(Node<T> node){
        // 递归方法一定要有合适的退出机制
        if (node == null){
            return;
        }
        PostorderRecursive(node.left);
        PostorderRecursive(node.right);
        System.out.println(node.data);
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


        PreorderRecursive(root);
        System.out.println("====先序遍历====");
        InorderRecursive(root);
        System.out.println("====中序遍历====");
        PostorderRecursive(root);
        System.out.println("====后续遍历====");
    }
}
