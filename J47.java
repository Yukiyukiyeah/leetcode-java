/*
 * @Author: your name
 * @Date: 2020-12-17 14:47:14
 * @LastEditTime: 2020-12-17 14:52:33
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/J47.java
 */
class Solution {
  public int maxValue(int[][] grid) {
      int m = grid.length - 1;
      int n = grid[0].length - 1;
      int res = grid[0][0];
      for (int j = 1; j <= n; j++) {
          grid[0][j] += grid[0][j-1];
      }
      for (int i = 1; i <= m; i++) {
          grid[i][0] += grid[i-1][0];
      }
      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {
              grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
          }
      }
      return grid[m][n];
  }
}