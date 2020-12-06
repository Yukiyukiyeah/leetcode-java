/*
 * @Author: your name
 * @Date: 2020-12-06 17:39:05
 * @LastEditTime: 2020-12-06 17:39:05
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/131.palindrome-partitioning.java
 */
class Solution {
  public List<List<String>> partition(String s) {
      List<List<String>> res = new ArrayList<>();
      dfs(s, 0, new ArrayList<String>(), res);
      return res;
  }
  private void dfs(String s, int index, List<String> curr, List<List<String>> res) {
      if (index == s.length()) {
          if (curr != null) {
              res.add(new ArrayList(curr));
          }
      }
      for (int i = 1; index + i <= s.length(); i++) {
          String temp = s.substring(index, index + i);
          if (i == 1 || isPalindrome(temp) == true) {
              curr.add(temp);
              dfs(s, index + i, curr, res);
              curr.remove(curr.size() - 1);
          }
      }
  }
  private Boolean isPalindrome(String s) {
      int l = 0;
      int r = s.length() - 1;
      while (l < r) {
          if (s.charAt(l) != s.charAt(r)) {
              return false;
          }
          l++;
          r--;
      }
      return true;
  }
      
}