/*
 * @Author: your name
 * @Date: 2020-12-15 14:56:04
 * @LastEditTime: 2020-12-15 14:56:19
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/559.maximum-depth-of-n-aray-tree.java
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
  public int maxDepth(Node root) {
      if (root == null) return 0;
      int depth = 0;
      Queue<Node> q = new LinkedList<>();
      q.offer(root);
      while (!q.isEmpty()) {
          int sz = q.size();
          depth++;
          for (int i = 0; i < sz; i++) {
              Node cur = q.poll();
              if (cur.children != null) {
                  for (Node s: cur.children) {
                      q.offer(s);
                  }
              }
          }
      }
      return depth;
  }
}