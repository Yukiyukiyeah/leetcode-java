/*
 * @Author: your name
 * @Date: 2020-12-28 00:07:06
 * @LastEditTime: 2020-12-28 00:07:21
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/147.insertion-sort-list.java
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode insertionSortList(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode sentinel = new ListNode(0);
      sentinel.next = head;
      ListNode lastSorted = head;
      ListNode curr = head.next;
      while(curr != null) {
          if (curr.val >= lastSorted.val ) {
              lastSorted = lastSorted.next;
          } else {
              ListNode prev = sentinel;
              while (prev.next.val < curr.val) {
                  prev = prev.next;
              }
              lastSorted.next = curr.next;
              curr.next = prev.next;
              prev.next = curr;
          }
          curr = lastSorted.next;
      }
      return sentinel.next;
  }
}