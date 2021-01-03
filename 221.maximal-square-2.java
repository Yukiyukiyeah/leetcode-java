/*
 * @Author: your name
 * @Date: 2021-01-02 22:59:13
 * @LastEditTime: 2021-01-02 22:59:14
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/221.maximal-square-2.java
 */
class Solution {
  public int maximalSquare(char[][] matrix) {
      int max = 0;
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
      int[][] dp = new int[matrix.length][matrix[0].length];
      for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[0].length; j++) {
              if (matrix[i][j] == '1') {
                  if (i == 0 || j == 0) {
                      dp[i][j] = 1;
                  } else {
                      dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                  }
                  if (dp[i][j] > max) max = dp[i][j];
              }
          }
      }
      return max * max;
  }
}
