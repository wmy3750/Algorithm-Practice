package com.wmy.binaryTree.bst;

import com.wmy.TreeNode;

/**
 * @author wangmengyao
 * @Date 2025/4/16 14:27
 */

public class LeetCode_S701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
