/*
 * @Author: your name
 * @Date: 2021-01-22 22:29:21
 * @LastEditTime: 2021-01-22 22:29:22
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/263.ugly-number.java
 */
class Solution {
  public boolean isUgly(int num) {
      if (num == 0) return false;
      while (num % 2 == 0) {
          num = num / 2;
      }
      while (num % 3 == 0) {
          num = num / 3;
      }
      while (num % 5 == 0) {
          num = num / 5;
      }
      return num == 1;
  }
}
