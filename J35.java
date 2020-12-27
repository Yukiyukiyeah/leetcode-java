/*
 * @Author: your name
 * @Date: 2020-12-25 21:01:44
 * @LastEditTime: 2020-12-27 19:31:09
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/J35.java
 */
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> visited = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (visited.containsKey(head)) return visited.get(head);
        Node newNode = new Node(head.val);
        visited.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
}