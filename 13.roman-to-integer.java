/*
 * @Author: your name
 * @Date: 2021-01-03 14:32:00
 * @LastEditTime: 2021-01-03 14:32:01
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/13.roman-to-integer.java
 */
class Solution {
    
  public int romanToInt(String s) {
      char[] sArr = s.toCharArray();
      int res = 0;
      int prev = value(sArr[0]);
      for (int i = 1; i < sArr.length; i++) {
          int cur = value(sArr[i]);
          if (prev < cur) {
              res -= prev;
          } else {
              res += prev;
          }
          prev = cur;
      }
      res += prev;
      return res;
  }

  private int value(char c) {
      switch(c) {
          case 'I': return 1;
          case 'V': return 5;
          case 'X': return 10;
          case 'L': return 50;
          case 'C': return 100;
          case 'D': return 500;
          case 'M': return 1000;
          default: return 0;
      }
  }
}
