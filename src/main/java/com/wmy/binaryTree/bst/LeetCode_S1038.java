package com.wmy.binaryTree.bst;

import com.wmy.TreeNode;
import com.wmy.TreeNodeOperate;

/**
 * @author wangmengyao
 * @Date 2025/4/16 14:27
 */
// 一眼看出中序遍历反向遍历，所以可以利用中序遍历的反向遍历，求出每个节点的值
public class LeetCode_S1038 {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        LeetCode_S1038 solution = new LeetCode_S1038();
        TreeNodeOperate.printTree(root);
        TreeNode newRoot = solution.bstToGst(root);
        TreeNodeOperate.printTree(newRoot);
    }
}
