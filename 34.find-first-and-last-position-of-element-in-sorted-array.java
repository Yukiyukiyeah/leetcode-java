/*
 * @Author: your name
 * @Date: 2021-01-27 23:35:05
 * @LastEditTime: 2021-01-27 23:35:32
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/34.find-first-and-last-position-of-element-in-sorted-array.java
 */
class Solution {
  public int[] searchRange(int[] nums, int target) {
      int start = 0;
      int end = nums.length - 1;
      int[] res = {-1, -1};
      while (start <= end) {
          int mid = start + (end - start) / 2;
          if (nums[mid] < target) {
              start = mid + 1;
          } else if (nums[mid] > target) {
              end = mid - 1;
          } else {
              if (nums[start] == target && nums[end] == target) {
                  res[0] = start;
                  res[1] = end;
                  break;
              } else if (nums[start] != target) {
                  start++;
              } else if (nums[end] != target) {
                  end--;
              }
          }
      }
      return res;
  }
}