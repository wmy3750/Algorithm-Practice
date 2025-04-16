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
 * 确定根节点的值是 preorder[preStart]
 * 明显发现左树节点个数无法确定，但前序遍历第一个pop出的节点的下一个节点是左孩子，则前序遍历的左节点= preorder[preStart + 1]
 * 确定前序遍历左孩子范围是 preStart + 1 ~ preStart + x
 * 确定后序遍历左孩子范围是 postStart ~ postStart + x - 1
 * 确定前序遍历右孩子范围是 preStart + x + 1 ~ preEnd
 * 确定后序遍历右孩子范围是 postStart + x ~ postEnd - 1
 * 状态方程确认一半了
 * 左树状态方程是 build(preorder,  preStart + 1, preStart + x, postorder, postStart, postStart + x - 1)
 * 右树树状态方程是 build(inorder, preStart + x + 1, preEnd, postorder, postStart + x, postEnd - 1)
 * x如何去确认?
 * 假设后序遍历的左树节点右x个，那么在后序遍历中，根据 前序遍历的左节点= preorder[preStart + 1] 易得到 后序中的 postLeftIndex 则 x = postLeftIndex - postStart + 1
 * 所以
 * 左树状态方程是 build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, postLeftIndex)
 * 右树树状态方程是 build(preorder, preStart + leftSize + 1, preEnd, postorder, postLeftIndex + 1, postEnd - 1)
 */
public class LeetCode_S889 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || preorder.length == 0
                || postorder == null || postorder.length == 0
                || preorder.length != postorder.length) {
            return null;
        }
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int rootValue = preorder[preStart];
        int leftValue = preorder[preStart + 1];
        int postLeftIndex = map.get(leftValue);
        int leftSize = postLeftIndex - postStart + 1;
        TreeNode root = new TreeNode(rootValue);
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, postLeftIndex);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, postLeftIndex + 1, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        LeetCode_S889 leetCode_s889 = new LeetCode_S889();
        TreeNode treeNode = leetCode_s889.constructFromPrePost(preorder, postorder);
        System.out.println(JSONUtil.toJsonStr(treeNode));
    }
}

