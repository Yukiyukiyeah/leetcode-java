/*
 * @Author: your name
 * @Date: 2020-12-12 14:26:10
 * @LastEditTime: 2020-12-12 14:26:12
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/52.n-queen2.java
 */
public class Solution {
  int res = 0;
  public int totalNQueens(int n) {
      char[][] board = new char[n][n];
      for (int i = 0; i < n; i++){
          for (int j = 0; j < n; j++) {
              board[i][j] = '.';
          }
      }
      backtrack(board, 0);
      return res;
  }
  private void backtrack(char[][] board, int row) {
      if (row == board.length) {
          res += 1;
          return;
      }
      for (int col = 0; col < board.length; col++) {
          if (!isValid(board, row, col)) {
              continue;
          }
          board[row][col] = 'Q';
          backtrack(board, row + 1);
          board[row][col] = '.';
      }
  }

  private boolean isValid(char[][]board, int row, int col) {
      for (int i = 0; i < row; i++) {
          if (board[i][col] == 'Q'){
              return false;
          }
      }
      for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
          if (board[i][j] == 'Q') {
              return false;
          }
      }
      for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
          if (board[i][j] == 'Q') {
              return false;
          }
      }
      return true;
  }

  private List<String> construct(char[][] board) {
      List<String> ans = new ArrayList<String>();
      for (int i = 0; i < board.length; i++) {
          ans.add(new String(board[i]));
      }
      return ans;
  }
}
  
}
