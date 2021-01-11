/*
 * @Author: your name
 * @Date: 2021-01-11 22:28:32
 * @LastEditTime: 2021-01-11 22:28:33
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/156.binary-tree-upside-down.java
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
  public TreeNode upsideDownBinaryTree(TreeNode root) {
      if (root == null || root.left == null) return root;
      TreeNode left = root.left;
      TreeNode right = root.right;
      TreeNode res = upsideDownBinaryTree(root.left);
      root.left = null;
      root.right = null;
      left.right = root;
      left.left = right;
      return res;
  }
}