/*
 * @Author: your name
 * @Date: 2020-12-14 13:00:42
 * @LastEditTime: 2020-12-14 13:02:23
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/107.binary-tree-level-order-traversal-II.java
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      Queue<TreeNode> q = new LinkedList<>();
      if (root == null) return res;
      q.offer(root);
      while (!q.isEmpty()) {
          List<Integer> level = new ArrayList<Integer>();
          int sz = q.size();
          for (int i = 0; i < sz; i++) {
              TreeNode cur = q.poll();
              level.add(cur.val);
              if (cur.left != null) {
                  q.offer(cur.left);
              }
              if (cur.right != null) {
                  q.offer(cur.right);
              }
          }
          res.add(0, level);
      }
      return res;
  }
}