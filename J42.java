class Solution {
  public int maxSubArray(int[] nums) {
      int res = nums[0];
      for (int i = 1; i < nums.length; i++) {
          nums[i] += Math.max(0, nums[i - 1]);
          res = Math.max(res, nums[i]);
      }
      return res;
  }
}
