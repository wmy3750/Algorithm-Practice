package com.wmy.binaryTree.bst;

/**
 * @author wangmengyao
 * @Date 2025/4/16 14:27
 */

public class LeetCode_S96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
    /* 难点在于 f(i)=G(i−1)∗G(n−i)
首先，这个公式翻译一下就是以i为根节点的二叉搜索树的数量等于以i-1的总数的二叉搜索树的数量乘以以n-1的二叉搜索树的数量。

什么意思呢？

意思就是

假设有n==100,i=50，那么就有以50这个数字为根节点的二叉搜索树的数量等于以49为总数的二叉搜索树的数量乘以以50为总数的二叉搜索树的数量。
注意，此时50和49和50，三个数字代表的是不同的意义，第一个50是根节点，第二个49是总数，第三个50还是总数。

想象一下，50这个数字的左边，很明显仅能够从1到49这49个数字进行挑选，这很好理解，因为二叉搜索树的左子树的所有值都必须小于根节点，
它们继续在50的左子树下面排列组合，得出的最终各种排列的总数就是G(49)。重点在后面，在50这个数字的根节点的右边，很显然只能是51到100，
这50个数字进行排列组合，此时很多人不理解，为什么51到100的排列组合的总数等于G(50)，G(50)从字面意义上看，也就是从0到50的排列组合的总数。

其实道理很简单，将51到100这些数字排列组合的总数，是等于从0到50的排列组合的总数的，因为将51替换为1，将52替换为2，以此类推下去，
将100替换为50，就很容易理解了，因为本质上就是50个从大到小的不同的数进行二叉树的排列组合，不论是1001到1050，还是从51到100，所排列组合的二叉树数量是一样的。

所以，这也就解释了这个公式为什么是f(50) = G(49) * G(50)，因为在50这个根节点的左边，有1到49这些数字在不断进行排列组合得出总的排列组合数，
在50的右边，有51到100这些数字同样的在不断的进行排列组合得出总的排列组合数，自然而然的，50作为根节点时，所能得到的不同组合，就是G(49) * G(50)了。
 */
    public static void main(String[] args) {
        LeetCode_S96 leetCode_s96 = new LeetCode_S96();
        int n = 3;
        int res = leetCode_s96.numTrees(n);
        System.out.println(res);
    }
}
