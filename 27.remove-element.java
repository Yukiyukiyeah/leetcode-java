/*
 * @Author: your name
 * @Date: 2021-01-24 21:39:45
 * @LastEditTime: 2021-01-24 21:39:46
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/27.remove-element.java
 */
class Solution {
  public int removeElement(int[] nums, int val) {
      int length = 0;
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] != val) {
              nums[length] = nums[i];
              length++;
          }
      }
      return length;
  }
}