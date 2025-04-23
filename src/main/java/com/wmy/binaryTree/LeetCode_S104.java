package com.wmy.binaryTree;

import cn.hutool.json.JSONUtil;
import com.wmy.TreeNode;
import com.wmy.TreeNodeOperate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmengyao
 * @Date 2025/4/15 15:06
 */

public class LeetCode_S104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNodeOperate treeNodeOperate = new TreeNodeOperate();
        TreeNode root = treeNodeOperate.createTreeByBFS(new Integer[]{3, 9, 20, null, null, 15, 7});
        treeNodeOperate.printTree(root);
    }
}

