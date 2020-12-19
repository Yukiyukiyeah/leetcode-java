class Solution {
  public int numWays(int n) {
      if (n == 0) return 1;
      if (n == 1) return 1;
      int a = 1;
      int b = 1;
      int res = 0;
      for (int i = 2; i <= n; i++) {
          res = (a + b) % 1000000007;
          a = b;
          b = res;
      }
      return res;
  }
}
