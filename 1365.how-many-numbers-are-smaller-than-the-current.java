/*
 * @Author: your name
 * @Date: 2021-01-07 21:05:25
 * @LastEditTime: 2021-01-07 21:05:26
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Editpublic class 1365.how-many-numbers-are-smaller-than-the-current {
   
 }
 
 * @FilePath: /leetcode-java/1365.how-many-numbers-are-smaller-than-the-current.java
 */
class Solution {
  public int[] smallerNumbersThanCurrent(int[] nums) {
      int[] cnt = new int[101];
      int n = nums.length;
      for (int i = 0; i < n; i++) {
          cnt[nums[i]]++;
      }
      for (int i = 1; i <= 100; i++) {
          cnt[i] += cnt[i - 1];
      }
      int[] ret = new int[n];
      for (int i = 0; i < n; i++) {
          ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
      }
      return ret;
  }
}
