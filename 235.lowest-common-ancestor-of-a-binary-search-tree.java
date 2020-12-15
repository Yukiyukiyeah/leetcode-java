/*
 * @Author: your name
 * @Date: 2020-12-15 16:33:17
 * @LastEditTime: 2020-12-15 16:33:50
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/235.lowest-common-ancestor-of-a-binary-search-tree.java
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
      if (root == null || root.val == p.val || root.val == q.val) return root;
      if (root.val < p.val && root.val < q.val) {
          return lowestCommonAncestor(root.right, p, q);
      } else if (root.val > p.val && root.val > q.val) {
          return lowestCommonAncestor(root.left, p, q);
      } else {
          return root;
      }
  }
}