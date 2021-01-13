/*
 * @Author: your name
 * @Date: 2021-01-13 01:51:00
 * @LastEditTime: 2021-01-13 01:56:34
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/200.num-islands2.java
 */
class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int row = grid.length;
    int col = grid[0].length;
    int numIslands = 0;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (grid[r][c] == '1') {
          numIslands++;
          dfs(grid, r, c);
        }
      }
    }
    return numIslands;
  }
  private void dfs(char[][] grid, int r, int c) {
    int row = grid.length;
    int col = grid[0].length;
    if (r < 0 || c <  0 || r >= row ||c >= col || grid[r][c] == '0') {
      return;
    }
    grid[r][c] = '0';
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);
  }
}
