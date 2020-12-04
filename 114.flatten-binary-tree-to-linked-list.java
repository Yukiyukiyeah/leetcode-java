/*
 * @Author: your name
 * @Date: 2020-12-04 12:12:39
 * @LastEditTime: 2020-12-04 12:12:46
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/114.flatten-binary-tree-to-linked-list.java
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public void flatten(TreeNode root) {
      if (root == null) return;
      flatten(root.left);
      flatten(root.right);
      TreeNode left = root.left;
      TreeNode right = root.right;
      root.left = null;
      root.right = left;
      TreeNode ptr = root;
      while (ptr.right != null) {
          ptr = ptr.right;
      }
      ptr.right = right;
  }
}