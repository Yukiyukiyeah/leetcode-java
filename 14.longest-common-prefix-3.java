/*
 * @Author: your name
 * @Date: 2021-01-05 13:29:36
 * @LastEditTime: 2021-01-05 13:29:37
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/14.longest-common-prefix-3.java
 */
class Solution {
  public String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) return "";
      String str = strs[0];
      for (int i = 1; i < strs.length; i++) {
          while (strs[i].indexOf(str) != 0) {
              str = str.substring(0, str.length() - 1);
          }
      }
      return str;
  }
}
