/*
 * @Author: your name
 * @Date: 2020-12-16 12:57:02
 * @LastEditTime: 2020-12-16 12:57:49
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/J34.java
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 注意创建linkedlist，加入结果时要new

class Solution {
  private List<List<Integer>> res = new LinkedList<>();
  private LinkedList<Integer> path = new LinkedList<>();
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
      dfs(root, sum);
      return res;
  }
  private void dfs(TreeNode root, int target) {
      if (root == null) return;
      path.add(root.val);
      target -= root.val;
      if (target == 0 && root.left == null && root.right == null) {
          res.add(new LinkedList(path));
      }
      dfs(root.left, target);
      dfs(root.right, target);
      path.removeLast();
  }
}
