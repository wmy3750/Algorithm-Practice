package com.wmy.binaryTree.bst;

import com.wmy.TreeNode;
import com.wmy.TreeNodeOperate;

/**
 * @author wangmengyao
 * @Date 2025/4/16 14:27
 */

/* 只能想起来保证左右子树是搜索二叉树，但二叉搜索树是左边节点全部小于root, min.val < root.val < max.val
 * 递归解法：
 * 1. 一棵树是否是搜索二叉树，需要左右都是搜索二叉树，且左子树最大值小于root，右子树最小值大于root
 * 2. 在左树中，向右的分支需要小于root，在右树中，向左的分支需要大于root
 */
public class LeetCode_S98 {
    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root, null, null);
    }

    // 定义：该函数返回 root 为根的子树的所有节点是否满足 max.val > root.val > min.val
    public boolean _isValidBST(TreeNode root, Integer min, Integer max) {
        // base case
        if (root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        // 根据定义，限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return _isValidBST(root.left, min, root.val)
                && _isValidBST(root.right, root.val, max);
    }


    public boolean isValidBST1(TreeNode root) {
        long[] res = _isValid(root);
        return res[0] == 1;
    }

    // 数组[是否BST, 树的最小值, 树的最大值]
    // 第二个元素标识
    public long[] _isValid(TreeNode root) {
        if (root == null) return new long[] {1, Long.MAX_VALUE, Long.MIN_VALUE};

        long[] leftRes = _isValid(root.left);
        long[] rightRes = _isValid(root.right);

        // 如果左/右子树不是搜索二叉树/root.val比左子树的最大值小/比右子树最小值还大，则不是搜索二叉树
        if (leftRes[0] == 0 || rightRes[0] == 0 || leftRes[2] >= root.val || rightRes[1] <= root.val) {
            return new long[] {0, 0, 0};
        } else {
            return new long[] {1, Math.min(leftRes[1], root.val), Math.max(rightRes[2], root.val)};
        }
    }
    public static void main(String[] args) {
        TreeNodeOperate treeNodeOperate = new TreeNodeOperate();
//        TreeNode root = treeNodeOperate.createTreeByBFS(new Integer[]{5, 4, 6, 3, 7, 3, 7});
        TreeNode root = treeNodeOperate.createTreeByBFS(new Integer[]{2147483647});
        treeNodeOperate.printTree(root);
        System.out.println("------------------------------------");
        LeetCode_S98 solution = new LeetCode_S98();
        System.out.println(solution.isValidBST1(root));
        System.out.println("------------------------------------");
    }
}
