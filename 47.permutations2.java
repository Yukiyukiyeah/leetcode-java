/*
 * @Author: your name
 * @Date: 2021-01-03 17:26:24
 * @LastEditTime: 2021-01-03 17:26:25
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/47.permutations2.java
 */
class Solution {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> path = new ArrayList<>();
  
  public List<List<Integer>> permuteUnique(int[] nums) {
      boolean[] visited = new boolean[nums.length];
      Arrays.sort(nums);
      dfs(0, nums, visited);
      return res;
  }

  private void dfs(int index, int[] nums, boolean[] visited) {
      if (index == nums.length) {
          res.add(new ArrayList(path));
          return;
      }
      for (int i = 0; i < nums.length; i++) {
          if (visited[i] || (i > 0 && nums[i-1] == nums[i] && !visited[i-1])) {
              continue;
          }
          path.add(nums[i]);
          visited[i] = true;
          dfs(index + 1, nums, visited);
          visited[i] = false;
          path.remove(index);
      }
  }
}
