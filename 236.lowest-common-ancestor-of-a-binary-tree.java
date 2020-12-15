/*
 * @Author: your name
 * @Date: 2020-12-15 16:30:09
 * @LastEditTime: 2020-12-15 16:30:34
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/236.lowest-common-ancestor-of-a-binary-tree.java
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
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || root.val == p.val || root.val == q.val) {
          return root;
      }
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);
      if (left == null) return right;
      else if (right == null) return left;
      else return root;
  }
}