/*
 * @Author: your name
 * @Date: 2021-01-09 10:50:45
 * @LastEditTime: 2021-01-09 10:50:46
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/24.swap-nodes-in-pairs-2.java
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
  public ListNode swapPairs(ListNode head) {
      ListNode sentinel = new ListNode();
      sentinel.next = head;
      ListNode tmp = sentinel;
      while (tmp.next != null && tmp.next.next != null) {
          ListNode l1 = tmp.next;
          ListNode l2 = tmp.next.next;
          tmp.next = l2;
          l1.next = l2.next;
          l2.next = l1;
          tmp = tmp.next.next;
      }
      return sentinel.next;
  }
}
