/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
      if (root == null) return "[]";
      StringBuilder res = new StringBuilder("[");
      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);
      while (!q.isEmpty()) {
          TreeNode cur = q.poll();
          if (cur != null) {
              res.append(cur.val + ",");
              q.offer(cur.left);
              q.offer(cur.right);
          } else {
              res.append("null,");
          }
      }
      res.deleteCharAt(res.length() - 1);
      res.append("]");
      return res.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
      if (data == "[]") return null;
      String[] vals = data.substring(1, data.length() - 1).split(",");
      Queue<TreeNode> q = new LinkedList<>();
      TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
      q.offer(root);
      int i = 1;
      while (!q.isEmpty()) {
          TreeNode cur = q.poll();
          if (!vals[i].equals("null")) {
              cur.left = new TreeNode(Integer.parseInt(vals[i]));
              q.offer(cur.left);
          }
          i++;
          if (!vals[i].equals("null")) {
              cur.right = new TreeNode(Integer.parseInt(vals[i]));
              q.offer(cur.right);
          }
          i++;
      }
      return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
