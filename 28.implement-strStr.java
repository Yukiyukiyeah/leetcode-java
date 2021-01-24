/*
 * @Author: your name
 * @Date: 2021-01-24 21:44:47
 * @LastEditTime: 2021-01-24 21:45:15
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/28.implement-strStr.java
 */
class Solution {
  public int strStr(String haystack, String needle) {
      for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
          if (haystack.substring(i, i + needle.length()).equals(needle)) {
              return i;
          }
      }
      return -1;
  }
}