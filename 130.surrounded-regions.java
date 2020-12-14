class Solution {
  int n, m;
  public void solve(char[][] board) {
      n = board.length;
      if (n == 0) return;
      m = board[0].length;
      for (int i = 0; i < n; i++) {
          dfs(board, i, 0);
          dfs(board, i, m - 1);
      }
      for (int i = 1; i < m - 1; i++) {
          dfs(board, 0, i);
          dfs(board, n - 1, i);
      }
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (board[i][j] == 'A') {
                  board[i][j] = 'O';
              } else if (board[i][j] == 'O') {
                  board[i][j] = 'X';
              }
          } 
      }
  }
  private void dfs(char[][] board, int row, int col) {
      if (row < 0 || row >= n || col < 0 || col >= m || board[row][col] != 'O') {
          return;
      }
      board[row][col] = 'A';
      dfs(board, row - 1, col);
      dfs(board, row + 1, col);
      dfs(board, row, col + 1);
      dfs(board, row, col - 1);
  }
}