/*
 * @Author: your name
 * @Date: 2020-12-02 15:47:22
 * @LastEditTime: 2020-12-02 15:47:33
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/81.search-in-rotated-sorted-arrray-II.java
 */
class Solution {
  public boolean search(int[] nums, int target) {
      int n = nums.length;
      if (n == 0) return false;
      int lo = 0;
      int hi = n - 1;
      while (lo <= hi) {
          int mid = lo + (hi - lo) / 2;
          if (nums[mid] == target) {
              return true;
          }
          if (nums[mid] == nums[lo]) {
              lo ++;
              continue;
          }
          boolean midInFirst = existsInFirst(nums, lo, nums[mid]);
          boolean targetInFirst = existsInFirst(nums, lo, target);
          if (midInFirst ^ targetInFirst) {
              if (midInFirst) {
                  lo = mid + 1;
              } else {
                  hi = mid - 1;
              }
          } else {
              if (nums[mid] < target) {
                  lo = mid + 1;
              } else {
                  hi = mid - 1;
              }
          }
      }
      return false;
  }
  private boolean existsInFirst(int[] arr, int start, int element) {
      return arr[start] <= element;
  }
}