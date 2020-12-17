/*
 * @Author: your name
 * @Date: 2020-12-17 13:16:37
 * @LastEditTime: 2020-12-17 13:16:56
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/J12-2.java
 */
// 字符串运算很费时，转化为数组
class Solution {
  public boolean exist(char[][] board, String word) {
      if (board == null) return false;
      char[] words = word.toCharArray();
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              boolean res = dfs(board, words, i, j, 0);
              if (res) return true;
          }
      }
      return false;
  }
  boolean dfs(char[][] board, char[] word, int i, int j, int k) {
      if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
      if(k == word.length - 1) return true;
      board[i][j] = '\0';
      boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || 
                      dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
      board[i][j] = word[k];
      return res;
  }

}
