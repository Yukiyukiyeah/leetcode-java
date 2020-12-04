/*
 * @Author: your name
 * @Date: 2020-12-04 13:56:41
 * @LastEditTime: 2020-12-04 13:56:41
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/96. unique-binary-search-trees.java
 */
class Solution {
  public int numTrees(int n) {
      int[] dp = new int[n+1];
      dp[0] = 1;
      for (int i = 1; i <= n; i++){
          for (int j = 0; j < i; j++) {
              dp[i] += dp[j] * dp[i - j - 1];
          }
      }
      return dp[n];
  }           
}