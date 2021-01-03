/*
 * @Author: your name
 * @Date: 2021-01-03 13:27:42
 * @LastEditTime: 2021-01-03 13:27:43
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/12.integer-to-roman.java
 */
class Solution {
  int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
  
  public String intToRoman(int num) {
      StringBuilder res = new StringBuilder();
      int ptr = 0;
      while (num > 0) {
          while (num < values[ptr]) {
              ptr ++;
          }
          res.append(symbols[ptr]);
          num -= values[ptr];
      }
      return res.toString();
  };
}
