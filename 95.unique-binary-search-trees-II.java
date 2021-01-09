/*
 * @Author: your name
 * @Date: 2020-12-04 13:00:27
 * @LastEditTime: 2020-12-04 13:00:27
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/95. unique-binary-search-trees-II.java
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
  public List<TreeNode> generateTrees(int n) {
      if (n == 0) return new ArrayList<TreeNode>();
      return generateTrees(1, n);
  }
  private List<TreeNode> generateTrees(int l, int r) {
      List<TreeNode> ans = new ArrayList<>();
      if (l > r) {
          ans.add(null);
          return ans;
      }
      for (int i = l; i <= r; i++) {
          for (TreeNode left : generateTrees(l, i - 1)) {
              for (TreeNode right : generateTrees(i + 1, r)) {
                  TreeNode root = new TreeNode(i);
                  root.left = left;
                  root.right = right;
                  ans.add(root);
              }
          }
      }
      return ans;
      
  }
}