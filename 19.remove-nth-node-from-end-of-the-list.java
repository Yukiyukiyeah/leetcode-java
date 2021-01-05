/*
 * @Author: your name
 * @Date: 2021-01-05 15:01:31
 * @LastEditTime: 2021-01-05 15:01:32
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/19.remove-nth-node-from-end-of-the-list.java
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode sentinel = new ListNode();
      sentinel.next = head;
      ListNode fast = sentinel;
      ListNode slow = sentinel;
      for (int i = 0; i < n; i++) {
          fast = fast.next;
      }
      while (fast.next != null) {
          fast = fast.next;
          slow = slow.next;
      }
      slow.next = slow.next.next;
      return sentinel.next;
  }
}
