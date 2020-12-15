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
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      if (root == null) return res;
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
      while (!q.isEmpty()) {
          int sz = q.size();
          List<Integer> level = new ArrayList<>();
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
          res.add(level);
      }
      return res;
  }
}