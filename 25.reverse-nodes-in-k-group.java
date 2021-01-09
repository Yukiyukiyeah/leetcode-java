/*
 * @Author: your name
 * @Date: 2021-01-09 15:14:15
 * @LastEditTime: 2021-01-09 15:23:05
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/25.reverse-nodes-in-k-group.java
 */
public class ListNode {
  int val;
  ListNode next;
  ListNode() {};
  ListNode(int val) { this.val = val; }
  ListNode(int val) { this.val = val;  this.next = next; }
}

class Solution{
  public ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1 || head == null) return head;
    ListNode l1 = head;
    ListNode l2 = head;
    for (int i = 0; i < k; i++) {
      if (l2 == null) return head;
      l2 = l2.next;
    }
    ListNode newHead = reverse(l1, l2);
    newHead.next = reverseKGroup(l2, k);
    return newHead;
  }
  private ListNode reverse(ListNode l1, ListNode l2) {
    ListNode prev = null;
    ListNode curr = l1;
    ListNode next = l1;
    while (curr != l2) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
