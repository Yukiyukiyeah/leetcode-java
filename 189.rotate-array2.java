/*
 * @Author: your name
 * @Date: 2020-12-08 15:33:38
 * @LastEditTime: 2020-12-08 15:33:39
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/189.rotate-array2.java
 */
class Solution {
  public void rotate(int[] nums, int k) {
      k %= nums.length;
      reverse(nums, 0, nums.length);
      reverse(nums, 0, k);
      reverse(nums, k, nums.length);
  }
  private void reverse(int[]nums, int start, int end) {
      end -= 1;
      while(start < end) {
          int tmp = nums[start];
          nums[start] = nums[end];
          nums[end] = tmp;
          start++;
          end--;
      }
  }
}
