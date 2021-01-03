/*
 * @Author: your name
 * @Date: 2021-01-02 21:41:05
 * @LastEditTime: 2021-01-02 21:41:06
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/7.reverse-integer.java
 */
class Solution {
  public int reverse(int x) {
      long ans = 0;
      while (x != 0) {
          ans = ans * 10 + x % 10;
          x /= 10;
      }
      return (int)ans == ans ? (int)ans : 0;
  }
}