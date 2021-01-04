/*
 * @Author: your name
 * @Date: 2021-01-04 20:23:30
 * @LastEditTime: 2021-01-04 20:23:51
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/14.longest-common-prefix-2.java
 */
class Solution {
  public String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) return "";
      int minLength = Integer.MAX_VALUE;
      for (String str : strs) {
          minLength = Math.min(minLength, str.length());
      }
      int start = 0;
      int end = minLength;
      while (start < end) {
          int mid = start + (end - start + 1) / 2;
          if (isPrefix(mid, strs)) {
              start = mid;
          } else {
              end = mid - 1;
          }
      }
      return strs[0].substring(0, start);
  }

  private boolean isPrefix(int mid, String[] strs) {
      String str = strs[0].substring(0, mid);
      for (int i = 0; i < strs.length; i++) {
          String s = strs[i];
          for (int j = 0; j < mid; j++) {
              if (str.charAt(j) != s.charAt(j)) {
                  return false;
              }
          }
      }
      return true;
  }
}