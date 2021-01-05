class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      if (nums == null || nums.length < 4) return res;
      Arrays.sort(nums);
      for (int i = 0; i < nums.length - 3; i++) {
          if (i > 0 && nums[i-1] == nums[i]) {
              continue;
          }
          if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
          if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) continue;
          for (int j = i + 1; j < nums.length - 2; j++) {
              if (j > i + 1 && nums[j-1] == nums[j]) {
                  continue;
              }
              if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
              if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) continue;
              int left = j + 1;
              int right = nums.length - 1;
              while (left < right) {
                  int sum = nums[i] + nums[j] + nums[left] + nums[right];
                  if (sum == target) {
                      res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                      while (left < right && nums[left+1] == nums[left]) {
                          left++;
                      }
                      left++;
                      while (left < right && nums[right-1] == nums[right]) {
                          right--;
                      }
                      right--;
                  } else if (sum < target) {
                      left++;
                  } else {
                      right--;
                  }
              }
          }
      }
      return res;
  }
}