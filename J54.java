/*
 * @Author: your name
 * @Date: 2020-12-16 13:59:07
 * @LastEditTime: 2020-12-16 14:00:13
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/J54.java
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
// global k
class Solution {
  int res, k;
  public int kthLargest(TreeNode root, int k) {
      this.k = k;
      dfs(root);
      return res;
  }
  private void dfs(TreeNode root) {
      if (root == null) return;
      dfs(root.right);
      k--;
      if (k == 0) res = root.val;
      dfs(root.left);
  }
}