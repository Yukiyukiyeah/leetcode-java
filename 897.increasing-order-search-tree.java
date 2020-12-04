/*
 * @Author: your name
 * @Date: 2020-12-04 11:52:24
 * @LastEditTime: 2020-12-04 11:52:25
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Editpublic class 897.increasing-order-search-tree {
   
 }
 
 * @FilePath: /leetcode-java/897.increasing-order-search-tree.java
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
  TreeNode curr;
  public TreeNode increasingBST(TreeNode root) {
      TreeNode ans = new TreeNode();
      curr = ans;
      inorder(root);
      return ans.right;
  }
  private void inorder(TreeNode node) {
      if (node == null) return;
      inorder(node.left);
      node.left = null;
      curr.right = node;
      curr = node;
      inorder(node.right);
  }
}