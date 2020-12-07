/*
 * @Author: your name
 * @Date: 2020-12-07 22:50:26
 * @LastEditTime: 2020-12-07 22:50:27
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/139.word-break2.java
 */
class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
      boolean[] dp = new boolean[s.length() + 1];
      Set<String> wordSet = new HashSet<>(wordDict);
      dp[0] = true;
      for (int i = 1; i <= s.length(); i++) {
          for (int j = 0; j < i; j++) {
              if (dp[j] && wordSet.contains(s.substring(j, i))) {
                  dp[i] = true; 
                  break;
              }
          }
      }
      return dp[s.length()];
  }
}