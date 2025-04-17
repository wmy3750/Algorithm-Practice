package com.wmy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wangmengyao
 * @Date 2025/4/16 14:00
 */
public class TreeNodeOperate {

    // 打印树的结构（树状结构）
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        List<List<String>> levels = buildTreeStructure(root);
        printTreeStructure(levels);
    }

    // 构建树的结构
    private static List<List<String>> buildTreeStructure(TreeNode root) {
        int depth = getDepth(root);
        List<List<String>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 0; i < depth; i++) {
            int levelSize = queue.size();
            List<String> level = new ArrayList<>();
            for (int j = 0; j < levelSize; j++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    level.add("#");
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    level.add(String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            levels.add(level);
        }

        return levels;
    }

    // 获取树的最大深度
    private static int getDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    // 打印树的结构
    private static void printTreeStructure(List<List<String>> levels) {
        int maxDepth = levels.size();
        int width = (1 << maxDepth) - 1;

        for (int i = 0; i < levels.size(); i++) {
            List<String> level = levels.get(i);
            int spacing = (1 << (maxDepth - i - 1)) - 1;
            StringBuilder sb = new StringBuilder();
            for (String node : level) {
                sb.append(repeat(" ", spacing));
                sb.append(node);
                sb.append(repeat(" ", spacing));
            }
            System.out.println(sb.toString());
        }
    }

    public static String repeat(String str, int count) {
        if (count <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public TreeNode createTreeByBFS(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (index < array.length) {
            TreeNode node = queue.poll();

            // 左子节点
            if (index < array.length && array[index] != null) {
                node.left = new TreeNode(array[index]);
                queue.offer(node.left);
            }
            index++;

            // 右子节点
            if (index < array.length && array[index] != null) {
                node.right = new TreeNode(array[index]);
                queue.offer(node.right);
            }
            index++;
        }

        return root;
    }
}
