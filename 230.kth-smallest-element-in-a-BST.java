/*
 * @Author: your name
 * @Date: 2020-12-04 14:29:53
 * @LastEditTime: 2020-12-04 14:30:12
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/230.kth-smallest-element-in-a-BST.java
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
      ArrayList<Integer> ans = inorder(root, new ArrayList<Integer>());
      return ans.get(k - 1);
  }
  private ArrayList<Integer> inorder(TreeNode node, ArrayList<Integer> ans) {
      if (node == null) return ans;
      inorder(node.left, ans);
      ans.add(node.val);
      inorder(node.right, ans);
      return ans;        
  }
}