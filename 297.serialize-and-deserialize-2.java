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
      return serialize(root, "");
  }

  private String serialize(TreeNode root, String s) {
      if (root == null) return s + "null,";
      s += s.valueOf(root.val) + ",";
      s = serialize(root.left, s);
      s = serialize(root.right, s);
      return s;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
      String[] dataArray = data.split(",");
      List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
      return rdeserialize(dataList);
  }

  private TreeNode rdeserialize(List<String> dataList) {
      if (dataList.get(0).equals("null")) {
          dataList.remove(0);
          return null;
      }
      TreeNode cur = new TreeNode(Integer.parseInt(dataList.get(0)));
      dataList.remove(0);
      cur.left = rdeserialize(dataList);
      cur.right = rdeserialize(dataList);
      return cur;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));