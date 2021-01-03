/*
 * @Author: your name
 * @Date: 2021-01-02 22:10:58
 * @LastEditTime: 2021-01-02 22:10:59
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/8.string-to-integer.java
 */
class Solution {
  public int myAtoi(String s) {
      int len = s.length();
      if (len == 0) return 0;
      char[] sArr = s.toCharArray();
      int i = 0;
      while (i < len && sArr[i] == ' ') {
          i++;
      }
      if (i == len) {
          return 0;
      }
      int sign = 1;
      if (sArr[i] == '+') {
          i++;
      } else if (sArr[i] == '-') {
          sign = -1;
          i++;
      }
      int res = 0;
      while (i < len && sArr[i] >= '0' && sArr[i] <='9') {
          if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && sArr[i] > '7')) return Integer.MAX_VALUE;
          if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && sArr[i] > '8')) return Integer.MIN_VALUE;
          res = res * 10 + sign * (sArr[i] - '0');
          i++;
      }
      // System.out.println(res);
      return res;
  }
}
