package com.wmy.binaryTree.bst;

import com.wmy.TreeNode;
import com.wmy.TreeNodeOperate;

/**
 * @author wangmengyao
 * @Date 2025/4/16 14:27
 */
/* 第二种方法
 * 1. 当前值大于key,则在左树找到要删除的节点
 * 2. 当前值小于key,则在右树找到要删除的节点
 * 3. 找到删除的节点，但有多种情况
 * 3.1 当前节点的左右子树均为null，则返回null
 * 3.2 当前节点的左子树为null，则当前节点移到右子树第一个节点
 * 3.3 当前节点的右子树为null，则当前节点移到左子树第一个节点
 * 3.4 当前节点的左右子树均不为null，
 *      a.则要找到左树最大值，删除左树最大值节点，当前节点替换为该最大值
 *      b.则要找到右树最小值，删除右树最小值节点，当前节点替换为该最小值
 */
public class LeetCode_S450_method2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode minNode = root.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNodeOperate treeNodeOperate = new TreeNodeOperate();
//        TreeNode root = treeNodeOperate.createTreeByBFS(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode root = treeNodeOperate.createTreeByBFS(new Integer[]{50,30,70,null,40,60,80});
        treeNodeOperate.printTree(root);
        System.out.println("------------------------------------");
        LeetCode_S450_method2 solution = new LeetCode_S450_method2();
        root = solution.deleteNode(root, 50);
        treeNodeOperate.printTree(root);
    }
}
