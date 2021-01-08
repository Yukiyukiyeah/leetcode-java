/*
 * @Author: your name
 * @Date: 2021-01-08 17:31:26
 * @LastEditTime: 2021-01-08 17:33:55
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/24.swap-nodes-in-pairs.java
 */
public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) {this.val = val;}
  ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = head.next;
    head.next = swapPairs(newHead.next);
    newHead.next = head;
    return newHead;
  }
}