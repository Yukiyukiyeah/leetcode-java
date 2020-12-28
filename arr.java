/*
 * @Author: your name
 * @Date: 2020-12-28 15:36:47
 * @LastEditTime: 2020-12-28 15:54:46
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/arr.java
 */
public class arr {
  public static class Node{
    int value;
    Node next;
  }
  public Node merge(Node l1, Node l2) {
    Node res = new Node();
    Node ptr = res;
    while (l1 != null && l2 != null) {
      if (l1.value < l2.value) {
        ptr.next = l1;
        l1 = l1.next;
      } else {
        ptr.next = l2;
        l2 = l2.next;
      }
      ptr = ptr.next;
    }
    if (l1 == null) {
      ptr.next = l2;
    } else {
      ptr.next = l1;
    }
    return res.next;
  }
}
