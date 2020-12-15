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
  public boolean isCousins(TreeNode root, int x, int y) {
      if (root == null || root.val == x || root.val == y) return false;
      if (root.left == null || root.right == null || root.left.val == x || root.right.val == x || root.left.val == y || root.right.val == y) {
          return false;
      }
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root.left);
      q.offer(root.right);
      while (!q.isEmpty()) {
          int sz = q.size();
          TreeNode xNode = null;
          TreeNode xParent = null;
          TreeNode yNode = null;
          TreeNode yParent = null;
          for (int i = 0; i < sz; i++) {
              TreeNode cur = q.poll();
              if (cur.left != null) {
                  q.offer(cur.left);
                  if (cur.left.val == x) {
                      xNode = cur.left;
                      xParent = cur;
                  }
                  if (cur.left.val == y) {
                      yNode = cur.left;
                      yParent = cur;
                  }
              }
              if (cur.right != null) {
                  q.offer(cur.right);
                  if (cur.right.val == x) {
                      xNode = cur.right;
                      xParent = cur;
                  }
                  if (cur.right.val == y) {
                      yNode = cur.right;
                      yParent = cur;
                  }
              }
          }
          if (xNode != null && yNode != null && xParent != yParent) {
              return true;
          } else if (xNode != null || yNode != null) {
              return false;
          }
      }
      return false;
  }
}