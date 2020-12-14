class Solution {
  int dx[] = {-1, 1, 0, 0};
  int dy[] = {0, 0, -1, 1};
  public void solve(char[][] board) {
      int n = board.length;
      if (n == 0) return;
      int m = board[0].length;
      Queue<int[]> q = new LinkedList<>();
      for (int i = 0; i < n; i++) {
          if (board[i][0] == 'O') {
              q.offer(new int[]{i, 0});
          }
          if (board[i][m-1] == 'O') {
              q.offer(new int[]{i, m-1});
          }
      }
      for (int i = 1; i < m - 1; i++) {
          if (board[0][i] == 'O') {
              q.offer(new int[]{0, i});
          }
          if (board[n-1][i] == 'O') {
              q.offer(new int[]{n-1, i});
          }
      }
      while (!q.isEmpty()){
          int[] cur = q.poll();
          int x = cur[0], y = cur[1];
          board[x][y] = 'A';
          for (int j = 0; j < 4; j++) {
              int mx = x + dx[j];
              int my = y + dy[j];
              if (mx >= 0 && mx < n && my >= 0 && my < m && board[mx][my] == 'O'){
                  q.offer(new int[]{mx, my});
              }
          }
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
}
