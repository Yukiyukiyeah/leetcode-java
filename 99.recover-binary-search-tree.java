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
  TreeNode wrong1;
  TreeNode wrong2;
  TreeNode prev = new TreeNode(Integer.MIN_VALUE);
  public void recoverTree(TreeNode root) {
      traverse(root);
      int tmp = wrong1.val;
      wrong1.val = wrong2.val;
      wrong2.val = tmp;
      return;
  }
  private void traverse(TreeNode node) {
      if (node == null) return;
      traverse(node.left);
      if (node.val < prev.val) {
          if (wrong1 == null) {
              wrong1 = prev;
          }
          wrong2 = node;
      }
      prev = node;
      traverse(node.right);
  }
}