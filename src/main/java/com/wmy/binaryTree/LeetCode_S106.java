package com.wmy.binaryTree;

import cn.hutool.json.JSONUtil;
import com.wmy.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
 * 确定中序遍历左孩子范围是 inStart ~ inRootIndex - 1
 * 确定中序遍历右孩子范围是 inRootIndex + 1 ~ inEnd
 * 确定后序遍历左孩子范围是 postStart ~ postStart + x - 1
 * 确定后序遍历右孩子范围是 postStart + x ~ postRootIndex - 1
 * 状态方程确认一半了
 * 左树状态方程是 build(inorder, inStart, inRootIndex - 1, postorder, postStart, postStart + x - 1)
 * 右树树状态方程是 build(inorder, inRootIndex + 1, inEnd, postorder, postStart + x, postRootIndex - 1)
 * x如何去确认？
 * 假设左树节点右x个，那么在中序遍历中，x可得出，x = inRootIndex - inStart
 * 所以
 * 左树状态方程是 build(inorder, inStart, inRootIndex - 1, postorder, postStart, postStart + inRootIndex - inStart - 1)
 * 右树树状态方程是 build(inorder, inRootIndex + 1, inEnd, postorder, postStart + inRootIndex - inStart, postRootIndex - 1)
 */
public class LeetCode_S106 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 ||
                postorder == null || postorder.length == 0 ||
                inorder.length != postorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        int inRootIndex = map.get(rootValue);
        int leftSize = inRootIndex - inStart;
        TreeNode root = new TreeNode(rootValue);
        root.left = build(inorder, inStart, inRootIndex - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, inRootIndex + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        LeetCode_S106 leetCode_s106 = new LeetCode_S106();
        TreeNode treeNode = leetCode_s106.buildTree(inorder, postorder);
        System.out.println(JSONUtil.toJsonStr(treeNode));
    }
}

