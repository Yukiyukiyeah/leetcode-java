/*
 * @Author: your name
 * @Date: 2020-12-24 13:57:16
 * @LastEditTime: 2020-12-24 13:57:25
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/148.sort-list.java
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
  public ListNode sortList(ListNode head) {
      if (head == null || head.next == null) {
          return head;
      }
      ListNode midNode = findMidNode(head);
      ListNode rightHead = midNode.next;
      midNode.next = null;
      
      ListNode left = sortList(head);
      ListNode right = sortList(rightHead);
      return mergeSortedList(left, right);
  }
  private ListNode findMidNode(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode slow = head;
      ListNode fast = head.next.next;
      while (fast != null && fast.next != null) {
          fast = fast.next.next;
          slow = slow.next;
      }
      return slow;        
  }
  private ListNode mergeSortedList(ListNode l1, ListNode l2) {
      ListNode cur = new ListNode();
      ListNode sentinel = cur;
      while (l1 != null && l2 != null) {
          if (l1.val < l2.val) {
              cur.next = l1;
              l1 = l1.next;
          } else {
              cur.next = l2;
              l2 = l2.next;
          }
          cur = cur.next;
      }
      cur.next = l1 == null? l2 : l1;
      return sentinel.next;
  }
}