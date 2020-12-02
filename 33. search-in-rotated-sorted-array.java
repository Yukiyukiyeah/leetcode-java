/*
 * @Author: your name
 * @Date: 2020-12-02 15:53:52
 * @LastEditTime: 2020-12-02 15:54:03
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/33. search-in-rotated-sorted-array.java
 */
class Solution {
  public int search(int[] nums, int target) {
      int n = nums.length;
      if (n == 0) return -1;
      int lo = 0;
      int hi = n - 1;
      while (lo <= hi) {
          int mid = lo + (hi - lo) / 2;
          if (nums[mid] == target) {
              return mid;
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
      return -1;
  }
  private boolean existsInFirst(int[] arr, int start, int element) {
      return arr[start] <= element;
  }
}
