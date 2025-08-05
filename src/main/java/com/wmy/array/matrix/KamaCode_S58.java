package com.wmy.array.matrix;

import java.util.Scanner;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */

/**
 * 题目描述
 * 给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和。
 * 输入描述
 * 第一行输入为整数数组 Array 的长度 n，接下来 n 行，每行一个整数，表示数组的元素。随后的输入为需要计算总和的区间下标：a，b （b > = a），直至文件结束。
 * 输出描述
 * 输出每个指定区间内元素的总和。
 * 输入示例
 * 5
 * 1
 * 2
 * 3
 * 4
 * 5
 * 0 1
 * 1 3
 * 输出示例
 * 3
 * 9
 * 提示信息
 * 数据范围：
 * 0 < n <= 100000
 */
public class KamaCode_S58 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = array[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + array[i];
        }

        int a, b;
        while (scanner.hasNextInt()) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            System.out.println(dp[b] - dp[a] + array[a]);
        }
    }
}
