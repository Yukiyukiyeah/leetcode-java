class Solution {
  int[] dx = {1, -1, 0, 0};
  int[] dy = {0, 0, 1, -1};
  public boolean exist(char[][] board, String word) {
      if (board == null) return false;
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              boolean res = dfs(board, word, i, j);
              if (res) return true;
          }
      }
      return false;
  }
  private boolean dfs(char[][] board, String word, int row, int col) {
      if (word.length() == 0) return true;
      if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(0)) {
          return false;
      }
      char tmp = board[row][col];
      board[row][col] = '.';
      for (int i = 0; i < 4; i++) {
          boolean res = dfs(board, word.substring(1), row + dx[i], col + dy[i]);
          if (res) return true; 
      }
      board[row][col] = tmp;
      return false;
  }
}