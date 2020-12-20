/*
 * @Author: your name
 * @Date: 2020-12-19 17:11:21
 * @LastEditTime: 2020-12-19 17:12:43
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/153.find-minimum-in-rotated-sorted-array.java
 */
class Solution {
  public int findMin(int[] nums) {
    // 在left < right的条件下，middle = (left + right) / 2，则middle一定小于right，所以nums[middle] 一定不等于 nums[right]
      int l = 0;
      int r = nums.length - 1;
      while (l < r) {
          int mid = l + (r - l) / 2;
          if (nums[mid] < nums[r]) {
              r = mid;
          } else if (nums[mid] > nums[r]) {
              l = mid + 1;
          } 
      }
      return nums[l];
  }
}