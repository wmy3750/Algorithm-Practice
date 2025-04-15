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
public class LeetCode_S654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                maxIndex = i;
                max = nums[i];
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = build(nums, start, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, end);
        return root;
    }
}

