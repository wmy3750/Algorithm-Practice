package com.wmy.binaryTree;

import com.wmy.TreeNode;
import com.wmy.TreeNodeOperate;

/**
 * @author wangmengyao
 * @Date 2025/4/15 15:06
 */

public class LeetCode_S111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) minDepth = Math.min(minDepth(root.left), minDepth);
        if (root.right != null) minDepth = Math.min(minDepth(root.right), minDepth);
        return minDepth + 1;
    }

    // 注意左/右为空的情况要以有值的那边算最小深度
    public static void main(String[] args) {
        TreeNodeOperate treeNodeOperate = new TreeNodeOperate();
        TreeNode root = treeNodeOperate.createTreeByBFS(new Integer[]{3, 9, 20, null, null, 15, 7});
        treeNodeOperate.printTree(root);
    }
}

