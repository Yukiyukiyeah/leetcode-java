/*
 * @Author: your name
 * @Date: 2021-01-13 01:50:01
 * @LastEditTime: 2021-01-13 01:50:47
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/200.num-islands.java
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
                grid[r][c] = '0';
                Queue<Integer> neighbors = new LinkedList<>();
                neighbors.add(r * col + c);
                while (!neighbors.isEmpty()) {
                    int id =  neighbors.remove();
                    int currRow  = id / col;
                    int currCol = id % col;
                    if (currRow - 1 >= 0 && grid[currRow - 1][currCol] == '1') {
                        neighbors.add((currRow - 1) * col + currCol);
                        grid[currRow - 1][currCol] = '0';
                    }
                    if (currRow + 1 < row && grid[currRow + 1][currCol] == '1') {
                        neighbors.add((currRow + 1) * col + currCol);
                        grid[currRow + 1][currCol] = '0';
                    }
                    if (currCol - 1 >= 0 && grid[currRow][currCol - 1] == '1') {
                        neighbors.add(currRow * col + currCol - 1);
                        grid[currRow][currCol - 1] = '0';
                    }
                    if (currCol + 1 < col && grid[currRow][currCol + 1] == '1') {
                        neighbors.add(currRow * col + currCol + 1);
                        grid[currRow][currCol + 1] = '0';
                    }
              }
          }
        }
      }
      return numIslands;
  }
}
