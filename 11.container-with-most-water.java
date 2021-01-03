/*
 * @Author: your name
 * @Date: 2021-01-03 13:04:21
 * @LastEditTime: 2021-01-03 13:04:22
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/11.container-with-most-water.java
 */
class Solution {
  public int maxArea(int[] height) {
      int max = 0;
      int left = 0, right = height.length - 1;
      int cur = 0;
      while (left < right) {
          if (height[left] < height[right]) {
              cur = (right - left) * height[left];
              left ++;
          }
          else {
              cur = (right - left) * height[right];
              right --;
          }
          max = Math.max(max, cur);
      }
      return max;
  }
}
