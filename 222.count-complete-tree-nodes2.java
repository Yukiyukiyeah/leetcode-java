/*
 * @Author: your name
 * @Date: 2020-12-05 17:48:35
 * @LastEditTime: 2020-12-05 17:48:36
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/222.count-complete-tree-nodes2.java
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
  public int countNodes(TreeNode root) {
      if (root == null) return 0; 
      int leftheight = leftHeight(root);
      if (leftHeight(root.right) + 1 == leftheight) {
          return (int)Math.pow(2, leftheight - 1) + countNodes(root.right);
      } else {
          return (int)Math.pow(2, leftheight - 2) + countNodes(root.left);
      }
      
  }
  private int leftHeight(TreeNode node) {
      if (node == null) return 0;
      return leftHeight(node.left) + 1;
  }
}