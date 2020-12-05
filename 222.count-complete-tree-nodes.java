/*
 * @Author: your name
 * @Date: 2020-12-05 17:36:31
 * @LastEditTime: 2020-12-05 17:36:47
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/222.count-complete-tree-nodes.java
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
      return 1 + countNodes(root.left) + countNodes(root.right);
      
  }
}