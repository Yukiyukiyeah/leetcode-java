/*
 * @Author: your name
 * @Date: 2020-12-31 18:09:31
 * @LastEditTime: 2020-12-31 19:02:02
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/9.palindrome-number.java
 */
class Solution {
  public boolean isPalindrome(int x) {
      if (x == 0) return true;
      if (x < 0 || x % 10 == 0 ) return false;
      int reverse = 0;
      while (x > reverse) {
        reverse = reverse * 10 + x % 10;
        x /= 10;
      }
      return x == reverse || x == reverse / 10;
  }
}