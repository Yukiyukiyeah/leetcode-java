/*
 * @Author: your name
 * @Date: 2021-01-03 17:15:55
 * @LastEditTime: 2021-01-03 17:15:56
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/46.permutations.java
 */
class Solution {
  List<List<Integer>> res = new ArrayList<>();
  ArrayList<Integer> path = new ArrayList<>();
  Set<Integer> visited = new HashSet<>();
  public List<List<Integer>> permute(int[] nums) {
      dfs(nums);
      return res;
  }
  private void dfs(int[] nums) {
      if (path.size() == nums.length) {
          res.add(new ArrayList(path));
          return;
      }
      for (int i = 0; i < nums.length; i++) {
          if (!visited.contains(i)) {
              path.add(nums[i]);
              visited.add(i);
              dfs(nums);
              visited.remove(i);
              path.remove(path.size() - 1);
          }
      }
      return;
  }
}