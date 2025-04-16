package com.wmy.binaryTree.postOrder;

import com.wmy.TreeNode;
import com.wmy.TreeNodeOperate;

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
public class LeetCode_S652 {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find(root);
        return res;
    }

    public String find(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String s = root.val + "," + find(root.left) + "," + find(root.right);
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) {
            res.add(root);
        }
        return s;
    }

    // 测试
    public static void main(String[] args) {
        // 示例 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(4);
        root1.right.left.left = new TreeNode(4);

        LeetCode_S652 solution = new LeetCode_S652();
        System.out.println("Example 1:");
        TreeNodeOperate.printTree(root1); // 打印原始树
        List<TreeNode> duplicates1 = solution.findDuplicateSubtrees(root1);
        solution.printDuplicateSubtrees(duplicates1); // 打印重复的子树

        // 示例 2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);

        System.out.println("\nExample 2:");
        TreeNodeOperate.printTree(root2); // 打印原始树
        List<TreeNode> duplicates2 = solution.findDuplicateSubtrees(root2);
        solution.printDuplicateSubtrees(duplicates2); // 打印重复的子树

        // 示例 3
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.right.left = new TreeNode(3);

        System.out.println("\nExample 3:");
        TreeNodeOperate.printTree(root3); // 打印原始树
        List<TreeNode> duplicates3 = solution.findDuplicateSubtrees(root3);
        solution.printDuplicateSubtrees(duplicates3); // 打印重复的子树
    }

    // 打印重复的子树
    public void printDuplicateSubtrees(List<TreeNode> duplicates) {
        System.out.println("Duplicate Subtrees:");
        for (int i = 0; i < duplicates.size(); i++) {
            System.out.println("Subtree " + (i + 1) + ":");
            TreeNodeOperate.printTree(duplicates.get(i));
        }
    }
}

