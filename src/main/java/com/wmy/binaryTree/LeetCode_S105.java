package com.wmy.binaryTree;

import com.wmy.TreeNode;

import java.util.HashMap;
import java.util.Map;
import cn.hutool.json.JSONUtil;

/**
 * @author wangmengyao
 * @Date 2025/4/15 15:06
 */

/*
 * 这题一上来你就知道了思路，但是根本不会写出来
 * 1. 知道是分解成子问题，动态规划的思路
 * 2. 确定递归的终止条件，以及递归的子问题
 * 3. 确定递归的子问题，以及子问题的终止条件
 * 4. 确定递归的返回值，以及递归的返回条件
 * 5. 确定递归的顺序，以及递归的顺序
 */

/*
        // 确定前序遍历左孩子范围是 preRootIndex + 1 ~ preRootIndex + x
        // 确定前序遍历右孩子范围是 preRootIndex + x + 1 ~ preEnd
        // 确定中序遍历左孩子范围是 inStart ~ inRootIndex - 1
        // 确定中序遍历右孩子范围是 inRootIndex + 1 ~ inEnd
        // 状态方程确认一半了，build(preorder, preRootIndex + 1, ?, inorder, ?, inEnd)
        // x如何去确认？
        // 假设左树节点右x个，那么在中序遍历中，x可得出，x = inRootIndex - inStart
        // 所以，
        // 左树状态方程是 build(preorder, preRootIndex + 1, preRootIndex + i - inRootIndex, inorder, inRootIndex, i - 1)
        // 右树树状态方程是 build(preorder, preRootIndex + i - inRootIndex + 1, preEnd, inorder, inRootIndex + 1, inEnd)
 */
public class LeetCode_S105 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 ||
                inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }
        //确定根节点的值
        int rootValue = preorder[preStart];
        //确定根节点的偏移量
        int inRootIndex = map.get(rootValue);

        // 确定左子树的个数 x = inRootIndex - inStart
        int leftSize = inRootIndex - inStart;

        // 构造根节点
        TreeNode root = new TreeNode(rootValue);
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, inRootIndex - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, inRootIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        LeetCode_S105 leetCode_s105 = new LeetCode_S105();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = leetCode_s105.buildTree(preorder, inorder);
        System.out.println(JSONUtil.toJsonPrettyStr(treeNode));
    }
}

