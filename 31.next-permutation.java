/*
 * @Author: your name
 * @Date: 2021-01-24 22:22:50
 * @LastEditTime: 2021-01-24 22:22:51
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/31.next-permutation.java
 */
class Solution {
  public void nextPermutation(int[] nums) {
      int cur = nums.length - 1;
      while (cur > 0 && nums[cur - 1] >= nums[cur]) {
          cur--;
      }
      if (cur == 0) {
          Arrays.sort(nums);
          return;
      }
      int swap = nums[cur - 1];
      int ptr = cur;
      while (ptr < nums.length && nums[ptr] > swap) {
          ptr++;
      }
      swap(nums, cur - 1, ptr - 1);
      reverse(nums, cur);
  }

  private void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
  }

  private void reverse(int[] nums, int start) {
      int i = start;
      int j = nums.length - 1;
      while (i < j) {
          swap(nums, i , j);
          i++;
          j--;
      }
  }
}