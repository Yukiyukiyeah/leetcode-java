class Solution {
  public boolean exist(char[][] board, String word) {
      if (board == null) return false;
      char[] words = word.toCharArray();
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              if (dfs(board, words, i, j, 0)) return true;
          }
      }
      return false;
  }
  private boolean dfs(char[][] board, char[] word, int r, int c, int k) {
      if (k == word.length) return true;
      if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || word[k] != board[r][c]) return false;
      char tmp = board[r][c];
      board[r][c] = ' ';
      boolean res = dfs(board, word, r + 1, c, k + 1) || dfs(board, word, r - 1, c, k + 1) || dfs(board, word, r, c + 1, k + 1) || dfs(board, word, r, c - 1, k + 1);
      board[r][c] = tmp;
      return res;
  }
}