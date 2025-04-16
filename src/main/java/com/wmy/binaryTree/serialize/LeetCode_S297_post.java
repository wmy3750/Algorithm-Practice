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
public class LeetCode_S297_post {

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
        serialize(root.right, sb);
        sb.append(root.val).append(",");
    }

    public TreeNode postOrderDeserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] chars = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(chars));
        return build(list);
    }

    private TreeNode build(List<String> list) {
        if (list.isEmpty()) return null;
        String val = list.remove(list.size() - 1);
        if (val.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.right = build(list);
        root.left = build(list);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        LeetCode_S297_post leetCode_s297 = new LeetCode_S297_post();
        String postorderSerialize = leetCode_s297.serialize(root);
        System.out.println(postorderSerialize);
        System.out.println("-----------------------");
        TreeNode postTreeNode = leetCode_s297.postOrderDeserialize(postorderSerialize);
        System.out.println(JSONUtil.toJsonStr(postTreeNode));
    }
}

