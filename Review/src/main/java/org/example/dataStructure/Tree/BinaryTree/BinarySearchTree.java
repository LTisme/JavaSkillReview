package org.example.dataStructure.Tree.BinaryTree;

/**
 * @Date: 2023/3/7
 * @Author: LTisme
 * @ClassName: BinarySearchTree
 * @Description: ---> 二叉查找树和二分查找的思路是一样的，首先这个树得满足左边子树的所有节点都小于根节点
 *                    右边子树的所有节点都大于根节点，用递归来实现。
 */

public class BinarySearchTree {
    /**
     * 二叉排序树
     *
     * @param root
     *            待查询的二叉排序树
     * @param target
     *            查找关键字
     * @return 没有返回null，有则返回节点
     */
    private static TreeNode searchBinaryTree(TreeNode root, int target) {
        if (root == null) { // 树节点不存在，返回
            return null;
        } else if (target == root.data) { // 查找成功
            return root;
        } else if (target < root.data) { // 关键字小于根节点查找左子树
            return searchBinaryTree(root.lchild, target);
        } else { // 关键字大于根节点查找右子树
            return searchBinaryTree(root.rchild, target);
        }
    }
    /**
     * 二叉树，数据结构
     *
     */
    private static class TreeNode {
        int data;
        TreeNode lchild;
        TreeNode rchild;
    }

    public static void main(String[] args) {
        // 主要是表达查询，所以手动构造一棵二叉排序树
        TreeNode binaryTree1 = new TreeNode();
        binaryTree1.data = 62;

        TreeNode binaryTree2 = new TreeNode();
        binaryTree1.lchild = binaryTree2;
        binaryTree2.data = 58;

        TreeNode binaryTree3 = new TreeNode();
        binaryTree2.lchild = binaryTree3;
        binaryTree3.data = 47;

        TreeNode binaryTree4 = new TreeNode();
        binaryTree3.lchild = binaryTree4;
        binaryTree4.data = 35;

        TreeNode binaryTree5 = new TreeNode();
        binaryTree4.rchild = binaryTree5;
        binaryTree5.data = 37;

        TreeNode binaryTree6 = new TreeNode();
        binaryTree3.rchild = binaryTree6;
        binaryTree6.data = 51;

        TreeNode binaryTree7 = new TreeNode();
        binaryTree1.rchild = binaryTree7;
        binaryTree7.data = 88;

        TreeNode binaryTree8 = new TreeNode();
        binaryTree7.lchild = binaryTree8;
        binaryTree8.data = 73;

        TreeNode binaryTree9 = new TreeNode();
        binaryTree7.rchild = binaryTree9;
        binaryTree9.data = 99;

        TreeNode binaryTree10 = new TreeNode();
        binaryTree9.lchild = binaryTree10;
        binaryTree10.data = 93;

        TreeNode treeNode = searchBinaryTree(binaryTree1, 35000);
        System.out.println(treeNode == null ? "没有这个数" : treeNode.data);
    }
}
