/*
 * @Author: your name
 * @Date: 2020-12-15 14:56:36
 * @LastEditTime: 2020-12-15 15:03:00
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/559.maximum-depth-of-n-ary-tree-2.java
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
      if (root == null) {
          return 0;
      } else if (root.children.isEmpty()) {
          return 1;
      } else {
          List<Integer> heights = new ArrayList<>();
          for (Node s: root.children) {
              heights.add(maxDepth(s));
          }
          return Collections.max(heights) + 1;
      }
  }
}