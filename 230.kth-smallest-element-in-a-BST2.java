/*
 * @Author: your name
 * @Date: 2020-12-05 19:15:54
 * @LastEditTime: 2020-12-05 19:16:09
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/230.kth-smallest-element-in-a-binary-tree.java
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
  public int kthSmallest(TreeNode root, int k) {
      Stack<TreeNode> stack = new Stack<TreeNode>();
      while (true) {
          while (root != null) {
              stack.push(root);
              root = root.left;
          }
          root = stack.pop();
          k -= 1;
          if (k == 0) {
              return root.val;
          }
          root = root.right;
      }
  }
}
