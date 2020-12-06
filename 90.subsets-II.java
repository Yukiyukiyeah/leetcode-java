/*
 * @Author: your name
 * @Date: 2020-12-06 16:36:54
 * @LastEditTime: 2020-12-06 16:36:55
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Editpublic class 90.subsets-II {
   
 }
 
 * @FilePath: /leetcode-java/90.subsets-II.java
 */
class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);
      dfs(nums, 0, new ArrayList<Integer>(), res);
      return res;
  }
  
  private void dfs(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
      res.add(new ArrayList<>(path));
      for (int i = start; i < nums.length; i++) {
          if (i > start && nums[i] == nums[i-1]) continue;
          path.add(nums[i]);
          dfs(nums, i + 1, path, res);
          path.remove(path.size() - 1);
      }
  }
}