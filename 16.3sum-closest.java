/*
 * @Author: your name
 * @Date: 2021-01-04 22:57:17
 * @LastEditTime: 2021-01-04 22:57:18
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/16.3sum-closest.java
 */
class Solution {
  public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int minDiff = Integer.MAX_VALUE;
      int res = target;
      for (int i = 0; i < nums.length - 2; i++) {
          if (i > 0 && nums[i] == nums[i-1]) {
              continue;
          }
          int start = i + 1;
          int end = nums.length - 1;
          while (start < end) {
              int sum = nums[i] + nums[start] + nums[end];
              if (sum == target) return target;
              if (Math.abs(sum - target) < minDiff) {
                  minDiff = Math.abs(sum - target);
                  res = sum;
              }
              if (sum > target) {
                  while (start < end && nums[end - 1] == nums[end]) {
                      end--;
                  }
                  end--;
              } else if (sum < target) {
                  while (start < end && nums[start] == nums[start + 1]) {
                      start++;
                  }
                  start++;
              }
          }
      }
      return res;
  }
}
