/*
 * @Author: your name
 * @Date: 2020-12-09 20:51:03
 * @LastEditTime: 2020-12-09 20:51:10
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/133.clone-graph.java
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
  private HashMap<Node, Node> visited = new HashMap<>();
  public Node cloneGraph(Node node) {
      if (node == null) {
          return null;
      }
      if (visited.containsKey(node)) {
          return visited.get(node);
      }
      Node newNode = new Node(node.val);
      visited.put(node, newNode);
      for (Node neighborNode: node.neighbors) {
          newNode.neighbors.add(cloneGraph(neighborNode));
      }
      return newNode;
  }
}