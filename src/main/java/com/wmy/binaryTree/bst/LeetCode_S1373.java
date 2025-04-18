package com.wmy.binaryTree.bst;

import cn.hutool.json.JSONUtil;
import com.wmy.TreeNode;
import com.wmy.TreeNodeOperate;

/**
 * @author wangmengyao
 * @Date 2025/4/16 14:27
 */

public class LeetCode_S1373 {
    int res = 0;
    public int maxSumBST(TreeNode root) {
        maxSum(root);
        return res;
    }

    // 数组[是否BST, 树的最小值, 树的最大值, BST的sum]
    public int[] maxSum(TreeNode root) {
        if (root == null) return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = maxSum(root.left);
        int[] right = maxSum(root.right);

        int rootVal = root.val;
        // 如果左右子树不是二叉搜索树、根节点的值小于左子树最大值，大于右子树最小值，则不是二叉搜索树
        if (left[0] == 0 || right[0] == 0 || rootVal <= left[2] || rootVal >= right[1]) {
            return new int[] {0, 0, 0, 0};
        }

        int sum = left[3] + right[3] + rootVal;
        res = Math.max(res, sum);

        return new int[] {1, Math.min(left[1], rootVal), Math.max(right[2], rootVal), sum};
    }
    /*
     * 本题和验证是否二叉搜索树很像，都是通过递归求解，都要注意左右子树即使是二叉搜索树，但也要保证整体是二叉搜索树
     * 如何保证呢，验证二叉搜索树是保证左树小于根节点，左树右孩子小于根节点，右树大于根节点，右树左孩子大于根节点
     * 那么， 这道题需要求和，一般求和都是后序遍历
     * 所以要维护一个数组，该数组第一个元素是当前节点所在树的最小值，第二个元素是当前节点所在树的最大值，第三个元素是当前节点的树是二叉搜索树的sum
     * 数组的第一个元素是当前节点的二叉树左子树的最大值，第二个元素是当前节点的二叉树的右子树的最小值，
     * 第三个元素是当前节点左右子树如果是二叉搜索树的和，否则为0
     * 关键点：
     * 数组第一个元素是左子树最大值，但是比较的时候，当前值必须要大于它，才符合二叉搜索树
     * 第二个元素是右子树最小值，但是比较的时候，当前值必须要小于它，才符合二叉搜索树
     * 所以返回值第一个元素是当前节点左子树的最大值，第二个元素是当前节点右子树的最小值，第三个元素是当前节点左右子树是二叉搜索树的和
     */

    public static void main(String[] args) {
        TreeNodeOperate treeNodeOperate = new TreeNodeOperate();
        TreeNode root = treeNodeOperate.createTreeByBFS(new Integer[]{1, null, 10, -5, 20});
        treeNodeOperate.printTree(root);
        System.out.println("------------------------------------");
        LeetCode_S1373 solution = new LeetCode_S1373();
        int res = solution.maxSumBST(root);
        System.out.println(res);
    }
}
