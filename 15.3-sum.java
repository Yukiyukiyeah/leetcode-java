/*
 * @Author: your name
 * @Date: 2021-01-04 21:49:08
 * @LastEditTime: 2021-01-04 22:37:23
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Editpublic class 15.3-sum {
   
 }
 
 * @FilePath: /leetcode-java/15.3-sum.java
 */
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) return new ArrayList<>();
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i-1]) continue;
      int start = i + 1;
      int end = nums.length - 1;
      while (start < end) {
        int sum = nums[i] + nums[start] + nums[end];
        if (sum == 0) {
          List<Integer> curr = new ArrayList<>();
          curr.add(nums[i]);
          curr.add(nums[start]);
          curr.add(nums[end]);
          res.add(curr);
          while (start < end && nums[start] == nums[start + 1]) {
            start++;
          }
          while (start < end && nums[end - 1] == nums[end]) {
            end--;
          }
          start++;
          end--;
        } else if (sum > 0) {
          end--;
        } else {
          start++;
        }
      }
    }
    return res;
  }
}