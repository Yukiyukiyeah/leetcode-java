/*
 * @Author: your name
 * @Date: 2021-01-17 23:04:20
 * @LastEditTime: 2021-01-17 23:04:30
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/1232.check-if-it-is-a-straight-line.java
 */
class Solution {
  public boolean checkStraightLine(int[][] coordinates) {
      int x = coordinates[1][0] - coordinates[0][0];
      int y = coordinates[1][1] - coordinates[0][1];
      for (int i = 1; i < coordinates.length - 1; i++) {
          int curX = coordinates[i+1][0] - coordinates[i][0];
          int curY = coordinates[i+1][1] - coordinates[i][1];
          if (curX * y - curY * x != 0) {
              return false;
          }
      }
      return true;
  }
}
