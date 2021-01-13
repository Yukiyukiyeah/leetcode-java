/*
 * @Author: your name
 * @Date: 2021-01-13 00:43:33
 * @LastEditTime: 2021-01-13 01:49:42
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Editpublic class binary-tree {
   
 }
 
 * @FilePath: /leetcode-java/binary-tree.java
 */
import java.util.*;
class BinaryTree{
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
  }
  public static int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
  }

  public static boolean isBalanced(TreeNode root) {
    return dfs(root)  != -1;
  }
  public static int dfs(TreeNode root) {
    if (root == null) return 0;
    int left = dfs(root.left);
    if (left == -1) return -1;
    int right = dfs(root.right);
    if (right == -1) return -1; 
    return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
  }

  public static numIslands(char[][] grid) {
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
            if (currRow + 1 < col && grid[currRow + 1][currCol] == '1') {
              neighbors.add((currRow + 1) * col + currCol);
              grid[currRow + 1][currCol] = '0';
            }
            if (currCol - 1 >= 0 && grid[currRow][currCol - 1] == '1') {
              neighbors.add(currRow * col + currCol - 1);
              grid[currRow][currCol - 1] = '0';
            }
            if (currRow + 1 < col && grid[currRow + 1][currCol] == '1') {
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