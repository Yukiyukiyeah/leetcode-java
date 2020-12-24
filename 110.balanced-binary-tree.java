/*
 * @Author: your name
 * @Date: 2020-12-24 13:32:58
 * @LastEditTime: 2020-12-24 13:32:58
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/110.balanced-binary-tree.java
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
  public boolean isBalanced(TreeNode root) {
      return height(root) >= 0;

  }
  private int height(TreeNode root) {
      if (root == null) return 0;
      int leftHeight = height(root.left);
      int rightHeight = height(root.right);
      if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
          return -1;
      } else {
          return Math.max(leftHeight, rightHeight) + 1;
      }
  }
}