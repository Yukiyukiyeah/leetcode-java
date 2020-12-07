/*
 * @Author: your name
 * @Date: 2020-12-07 23:11:40
 * @LastEditTime: 2020-12-07 23:12:00
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/219.contains-duplicate-II.java
 */
class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
          if (set.contains(nums[i])) {
              return true;
          }
          set.add(nums[i]);
          if (set.size() > k) {
              set.remove(nums[i - k]);
          }
      }
      return false;
  }
}