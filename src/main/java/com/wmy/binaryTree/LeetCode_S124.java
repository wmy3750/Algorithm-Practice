package com.wmy.binaryTree;

import com.wmy.TreeNode;
import com.wmy.TreeNodeOperate;

/**
 * @author wangmengyao
 * @Date 2025/4/15 15:06
 */

public class LeetCode_S124 {
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return sum;
    }

    public int maxPath(TreeNode root) {
        if (root == null) return 0;
        int leftMax = Math.max(0, maxPath(root.left));
        int rightMax = Math.max(0, maxPath(root.right));
        sum = Math.max(sum, leftMax + rightMax + root.val);
        return Math.max(leftMax, rightMax) + root.val;
    }
    // 难点在于递归返回值是0还是负数，所以需要Math.max(0, maxPath(root.left))，因为sum值是左右加根，如果左右有负数就不加，这样就能保证左右加根最大
    // 第二个难点，返回值需要返回左右子树最大值加根，因为在子树中，最大路径不能左根右，所以需要返回左右子树最大值加根
    public static void main(String[] args) {
        TreeNodeOperate treeNodeOperate = new TreeNodeOperate();
        TreeNode root = treeNodeOperate.createTreeByBFS(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        treeNodeOperate.printTree(root);
        System.out.println("------------------------------------");
        LeetCode_S124 solution = new LeetCode_S124();
        System.out.println(solution.maxPathSum(root));
    }
}

