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
  public int[] levelOrder(TreeNode root) {
      if (root == null) return new int[0];
      List<Integer> res = new ArrayList<>();
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
      while (!q.isEmpty()) {
          TreeNode cur = q.poll();
          res.add(cur.val);
          if (cur.left != null) {
              q.offer(cur.left);
          }
          if (cur.right != null) {
              q.offer(cur.right);
          }
      }
      int[] ans = new int[res.size()];
      for (int i = 0; i < res.size(); i++) {
          ans[i] = res.get(i);
      }
      return ans;
  }
}