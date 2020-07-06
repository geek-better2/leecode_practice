package com.hai.leecode.array;

/**
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class MaxmalSquare {

    //时间复杂度为O(nm),空间复杂度为O(nm)
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return maxSide;
        }
        int n = matrix.length,  m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return  maxSide * maxSide;
    }

    //时间复杂度为O(nm),空间复杂度为O(m)....引入了一个上访的变量
    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        int[] dp = new int[width + 1];

        for (char[] chars : matrix) {
            int northwest = 0; // 个人建议放在这里声明，而非循环体外
            for (int col = 0; col < width; col++) {
                int nextNorthwest = dp[col + 1];
                if (chars[col] == '1') {
                    //dp[col]代表左侧的值,dp[col + 1] 代表上一次的当前值,也就是上方的值,northwest 代表左上的值
                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northwest) + 1;
                    maxSide = Math.max(maxSide, dp[col + 1]);
                } else dp[col + 1] = 0;
                northwest = nextNorthwest;
            }
        }
        return maxSide * maxSide;
    }
    public static void main(String[] args) {
        char[][] arr = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        MaxmalSquare instance = new MaxmalSquare();
        int maxSquare = instance.maximalSquare2(arr);
        System.out.println("最大的正方形面积为:" + maxSquare);

    }
}
