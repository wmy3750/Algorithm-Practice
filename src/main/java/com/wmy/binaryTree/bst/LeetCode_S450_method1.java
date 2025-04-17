package com.wmy.binaryTree.bst;

import com.wmy.TreeNode;
import com.wmy.TreeNodeOperate;

/**
 * @author wangmengyao
 * @Date 2025/4/16 14:27
 */
public class LeetCode_S450_method1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }

    private TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) { // 删除左子树
            root.left = delete(root.left, key);
        } else if (root.val < key) { // 删除右子树
            root.right = delete(root.right, key);
        } else { // 删除当前节点, 找到右子树最小节点替换当前节点
            TreeNode left = root.left;
            TreeNode right = root.right;
            root = right;
            while (right != null && right.left != null) {
                right = right.left;
            }
            if (right != null) { // 右子树最小节点不为null，则右子树最小节点的左子树为当前节点的左子树
                right.left = left;
            } else { // 右子树最小节点为null，则当前节点的右子树为右子树最小节点的左子树
                root = left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNodeOperate treeNodeOperate = new TreeNodeOperate();
//        TreeNode root = treeNodeOperate.createTreeByBFS(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode root = treeNodeOperate.createTreeByBFS(new Integer[]{50,30,70,null,40,60,80});
        treeNodeOperate.printTree(root);
        System.out.println("------------------------------------");
        LeetCode_S450_method1 solution = new LeetCode_S450_method1();
        root = solution.deleteNode(root, 50);
        treeNodeOperate.printTree(root);
    }
}
