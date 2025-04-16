package com.wmy.binaryTree.bst;

import com.wmy.TreeNode;
import com.wmy.TreeNodeOperate;

/**
 * @author wangmengyao
 * @Date 2025/4/16 14:27
 */
// 一眼看出中序遍历反向遍历，所以可以利用中序遍历的反向遍历，求出每个节点的值
public class LeetCode_S230 {
    int count = 0;
    int target = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        target = k;
        kth(root);
        return result;
    }

    public void kth(TreeNode root) {
        if (root == null) return;
        kth(root.left);
        count++;
        if (count == target) result = root.val;
        kth(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        TreeNodeOperate.printTree(root);
        LeetCode_S230 solution = new LeetCode_S230();
        int kthSmallest = solution.kthSmallest(root, 3);
        System.out.println(kthSmallest);
        TreeNodeOperate.printTree(root);
    }
}
