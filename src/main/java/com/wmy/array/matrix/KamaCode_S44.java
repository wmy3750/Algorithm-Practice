package com.wmy.array.matrix;

import java.util.Scanner;

/**
 * @author wangmengyao
 * @Date 2025/4/21 15:54
 */

/**
 * 题目描述
 * 在一个城市区域内，被划分成了n * m个连续的区块，每个区块都拥有不同的权值，代表着其土地价值。目前，有两家开发公司，A 公司和 B 公司，希望购买这个城市区域的土地。
 *
 * 现在，需要将这个城市区域的所有区块分配给 A 公司和 B 公司。
 *
 * 然而，由于城市规划的限制，只允许将区域按横向或纵向划分成两个子区域，而且每个子区域都必须包含一个或多个区块。 为了确保公平竞争，你需要找到一种分配方式，使得 A 公司和 B 公司各自的子区域内的土地总价值之差最小。
 *
 * 注意：区块不可再分。
 *
 * 输入描述
 * 第一行输入两个正整数，代表 n 和 m。
 *
 * 接下来的 n 行，每行输出 m 个正整数。
 *
 * 输出描述
 * 请输出一个整数，代表两个子区域内土地总价值之间的最小差距。
 * 输入示例
 * 3 3
 * 1 2 3
 * 2 1 3
 * 1 2 3
 * 输出示例
 * 0
 * 提示信息
 * 如果将区域按照如下方式划分：
 *
 * 1 2 | 3
 * 2 1 | 3
 * 1 2 | 3
 *
 * 两个子区域内土地总价值之间的最小差距可以达到 0。
 *
 * 数据范围：
 *
 * 1 <= n, m <= 100；
 * n 和 m 不同时为 1。
 */
public class KamaCode_S44 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取输入的行
        int m = scanner.nextInt(); // 读取输入的列

        int[][] array = new int[n][m]; // 创建二维数组

        /**
         *  为什么是前缀和，注意题目的说法，只能横向或者纵向切割，那么横着切和竖着切，就是两个数组，一个行前缀和，一个列前缀和
         */
        int[] row = new int[n]; // 创建行前缀和数组
        int[] col = new int[m]; // 创建列前缀和数组

        for (int i = 0; i < n; i++) { // 读取输入的二维数组元素
            for (int j = 0; j < m; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        int rowSum = 0; // 行前缀和
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowSum += array[i][j];
            }
            row[i] = rowSum;
        }

        int colSum = 0; // 列前缀和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colSum += array[j][i];
            }
            col[i] = colSum;
        }

        int rowResult = KamaCode_S44.result(row); // 横切最小差值
        int colResult = KamaCode_S44.result(col); // 纵切最小差值

        System.out.println(Math.min(rowResult, colResult)); // 输出结果 两者取最小
    }

    /**
     * 这个方法求最小差距  也是非常的关键，比如横向切完，想要知道两个区域的差值，需要用总值减去区域一得到区域二再减去区域一才能得到差值
     * @param array
     * @return
     */
    public static int result(int[] array) { // 求最小差距
        int total = array[array.length - 1]; // 总和
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) { // 遍历数组 得到最小的差值
            res = Math.min(res, Math.abs((total - array[i]) - array[i]));
        }
        return res;
    }
}

