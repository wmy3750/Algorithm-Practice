package com.wmy.dynamicProgramming;

import com.wmy.TreeNode;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */
public class LeetCode_S337 {
    public int rob(TreeNode root) {
        return Math.max(maxRob(root)[0], maxRob(root)[1]);
    }
    private int[] maxRob(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = maxRob(root.left);
        int[] right = maxRob(root.right);

        // 不偷根节点
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // 偷根节点
        int rob = root.val + left[0] + right[0];
        return new int[]{notRob, rob};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(new LeetCode_S337().rob(root));
    }
}
