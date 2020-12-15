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
      boolean flag = true;
      while (!q.isEmpty()) {
          List<Integer> level = new ArrayList<>();
          int sz = q.size();
          for (int i = 0; i < sz; i++) {
              TreeNode cur = q.poll();
              if (flag == true) {
                  level.add(cur.val);
              } else {
                  level.add(0, cur.val);
              }
              if (cur.left != null) {
                  q.offer(cur.left);
              }
              if (cur.right != null) {
                  q.offer(cur.right);
              }
          }
          res.add(level);
          flag = !flag;
      }
      return res;
  }
}