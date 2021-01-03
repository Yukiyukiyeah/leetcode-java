/*
 * @Author: your name
 * @Date: 2021-01-02 22:43:47
 * @LastEditTime: 2021-01-02 22:44:11
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/221.maximal-square.java
 */
// 击败用户5%。。。。
class Solution {
  public int maximalSquare(char[][] matrix) {
      int max = 0;
      for (int i = 0; i < matrix.length - max; i++) {
          for (int j = 0; j < matrix[0].length - max; j++) {
              int row = i, col = j;
              int cur = 0;
              while (row < matrix.length && col < matrix[0].length && matrix[row][col] == '1') {
                  row ++;
                  col ++;
                  cur ++;
              }
              if (cur <= max) continue;
              else {
                  int border = 0;
                  for (int r = i; r < row; r++) {
                      for (int c = j; c < col; c++) {
                          if (matrix[r][c] != '1') {
                              border = Math.max(border, Math.min(row - r, col - c));
                          }
                      }
                  }
                  cur -= border;
                  if (cur > max) max = cur;
              }
          }
      }
      return max * max;
  }
}