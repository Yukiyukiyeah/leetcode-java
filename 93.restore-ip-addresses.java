/*
 * @Author: your name
 * @Date: 2020-12-06 17:01:21
 * @LastEditTime: 2020-12-06 17:01:22
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/93.restore-ip-addresses.java
 */
class Solution {
  public List<String> restoreIpAddresses(String s) {
      List<String> res = new ArrayList<>();
      dfs(s, 0, 4, "", res);
      return res;
  }
  private void dfs(String s, int index, int remain, String curr, List<String>res) {
      if (remain == 0) {
          if (index == s.length()){
              res.add(curr);
          }
          return;
      }
      for (int i = 1; i <= 3; i++) {
          if (index + i > s.length()) break;
          if (i != 1 && s.charAt(index) == '0') break;
          String temp = s.substring(index, index + i);
          int val = Integer.valueOf(temp);
          if (val <= 255) {
              dfs(s, index + i, remain - 1, curr + temp + (remain == 1 ? "" : "."), res);
          }
      }
  }
}
