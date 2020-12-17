class Solution {
  public boolean isMatch(String s, String p) {
      if (s == null || p == null) return false;
      int lenS = s.length();
      int lenP = p.length();
      boolean dp[][] = new boolean[lenS + 1][lenP + 1];
      dp[0][0] = true;
      for (int i = 1; i < lenP; i++) {
          if (p.charAt(i) == '*' && dp[0][i-1]) {
              dp[0][i+1] = true;
          }
      }
      for (int i = 0; i < lenS; i++) {
          for (int j = 0; j < lenP; j++) {
              if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                  dp[i+1][j+1] = dp[i][j];
              }
              if (p.charAt(j) == '*') {
                  if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                      dp[i+1][j+1] = dp[i+1][j-1];

                  } else {
                      dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1];
                  }
              }
          }
      }
      return dp[lenS][lenP];
  }
}