/*
 * @Author: your name
 * @Date: 2020-12-24 13:12:20
 * @LastEditTime: 2020-12-24 13:12:40
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/556.next-greater-element-III.java
 */
class Solution {
  public int nextGreaterElement(int n) {
      char[] number = (n + "").toCharArray();
      int i;
      int swapIndex1 = 0;
      for (i = number.length - 1; i > 0; i--) {
          if (number[i - 1] < number[i]) {
              swapIndex1 = i - 1;
              break;
          }
      }
      if (i == 0) return -1;
      char swapNum1 = number[swapIndex1];
      int swapIndex2 = swapIndex1;
      char swapNum2 = number[swapIndex1 + 1];
      for (int j = swapIndex1 + 1; j < number.length; j++) {
          if (number[j] > swapNum1 && number[j] <= swapNum2) {
              swapNum2 = number[j];
              swapIndex2 = j;
          }
      }
      number[swapIndex1] = swapNum2;
      number[swapIndex2] = swapNum1;
      // System.out.println(swapIndex1 + " " + swapIndex2);
      Arrays.sort(number, swapIndex1 + 1, number.length);
      try{
          return Integer.valueOf(new String(number));
      } catch (NumberFormatException e) {
          return -1;
      }
  }
}