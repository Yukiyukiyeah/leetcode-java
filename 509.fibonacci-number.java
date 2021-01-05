/*
 * @Author: your name
 * @Date: 2021-01-04 23:23:14
 * @LastEditTime: 2021-01-04 23:23:15
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/509.fibonacci-number.java
 */
class Solution {
  public int fib(int n) {
      if (n == 0 || n == 1) return n;
      int prev1 = 0, prev2 = 0;
      int curr = 1;
      for (int i = 2; i <= n; i++) {
          prev1 = prev2;
          prev2 = curr;
          curr = prev1 + prev2;
      }
      return curr;
  }
}