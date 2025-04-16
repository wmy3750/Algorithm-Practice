package com.wmy.binaryTree.serialize;

import cn.hutool.json.JSONUtil;
import com.wmy.TreeNode;

import java.util.*;

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
public class LeetCode_S297_pre {

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
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode preOrderDeserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] chars = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(chars));
        return build(list);
    }

    private TreeNode build(List<String> list) {
        if (list.isEmpty()) return null;
        String val = list.remove(0);
        if (val.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = build(list);
        root.right = build(list);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        LeetCode_S297_pre leetCode_s297Pre = new LeetCode_S297_pre();
        String preorderSerialize = leetCode_s297Pre.serialize(root);
        System.out.println(preorderSerialize);
        System.out.println("------------------------------------");
        TreeNode preTreeNode = leetCode_s297Pre.preOrderDeserialize(preorderSerialize);
        System.out.println(JSONUtil.toJsonStr(preTreeNode));
    }
}

