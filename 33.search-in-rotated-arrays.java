/*
 * @Author: your name
 * @Date: 2021-01-26 00:09:33
 * @LastEditTime: 2021-01-26 00:10:02
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/33.search-in-rotated-arrays.java
 */
class Solution {
  public int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {
          int mid = left + (right - left) / 2;
          if (nums[mid] == target) {
              return mid;
          } else if (nums[mid] >= nums[0]) {
              if (target < nums[mid] && target >= nums[0]) {
                  right = mid - 1;
              } else {
                  left = mid + 1;
              }
          } else {
              if (nums[mid] < target && target <= nums[nums.length - 1]) {
                  left = mid + 1;
              } else {
                  right = mid - 1;
              }
          }
      }
      return -1;
  }
}