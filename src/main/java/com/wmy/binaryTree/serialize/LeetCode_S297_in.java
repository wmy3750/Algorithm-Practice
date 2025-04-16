package com.wmy.binaryTree.serialize;

import cn.hutool.json.JSONUtil;
import com.wmy.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

 */
public class LeetCode_S297_in {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        serialize(root.left, sb);
        sb.append(root.val).append(",");
        serialize(root.right, sb);
    }


    // 前序和中序遍历反序列化
    public TreeNode deserialize(String preorder, String inorder) {
        if (preorder == null || preorder.isEmpty() || inorder == null || inorder.isEmpty()) {
            return null;
        }
        String[] preorderNodes = preorder.split(",");
        String[] inorderNodes = inorder.split(",");
        return deserialize(preorderNodes, inorderNodes, 0, preorderNodes.length - 1, 0, inorderNodes.length - 1);
    }

    private TreeNode deserialize(String[] preorder, String[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        String rootVal = preorder[preStart];
        if (rootVal.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        int rootIndex = findIndex(inorder, rootVal, inStart, inEnd);
        int leftLength = rootIndex - inStart;
        root.left = deserialize(preorder, inorder, preStart + 1, preStart + leftLength, inStart, rootIndex - 1);
        root.right = deserialize(preorder, inorder, preStart + leftLength + 1, preEnd, rootIndex + 1, inEnd);
        return root;
    }

    private int findIndex(String[] inorder, String val, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i].equals(val)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        LeetCode_S297_pre leetCode_s297Pre = new LeetCode_S297_pre();
        String preOrderSerialize = leetCode_s297Pre.serialize(root);
        System.out.println(preOrderSerialize);
        System.out.println("-------------------");

        LeetCode_S297_in leetCode_s297In = new LeetCode_S297_in();
        String inorderSerialize = leetCode_s297In.serialize(root);
        System.out.println(inorderSerialize);
        System.out.println("-------------------");

        TreeNode inTreeNode = leetCode_s297In.deserialize(preOrderSerialize, inorderSerialize);
        System.out.println(JSONUtil.toJsonStr(inTreeNode));
    }
}

