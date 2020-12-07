/*
 * @Author: your name
 * @Date: 2020-12-07 22:18:22
 * @LastEditTime: 2020-12-07 22:18:23
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/139.word-break.java
 */
class Solution {
  boolean mem[];
  public boolean wordBreak(String s, List<String> wordDict) {
      if (s == null) return false;
      this.mem = new boolean[s.length()];
      return dfs(s, wordDict, 0, s.length());
  }
  private boolean dfs(String s, List<String> wordDict, int start, int remain) {
      System.out.println(remain);
      if (remain == 0) {
          return true;
      }
      if (mem[start]) return false;
      for(int i = start + 1; i <= s.length(); i++) {
          String word = s.substring(start, i);
          System.out.println(word);
          if (wordDict.contains(word)) {
              if(dfs(s, wordDict, i, remain - (i - start))) return true;
          } 
      }
      mem[start] = true;
      return false;
  }
}