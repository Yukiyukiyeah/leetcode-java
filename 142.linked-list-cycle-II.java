/*
 * @Author: your name
 * @Date: 2020-12-13 08:48:16
 * @LastEditTime: 2020-12-13 08:48:17
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/142.linked-list-cycle-II.java
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode detectCycle(ListNode head) {
      ListNode slow, fast;
      slow = fast = head;
      while (fast != null && fast.next != null) {
          fast = fast.next.next;
          slow = slow.next;
          if (fast == slow) {
              fast = head;
              while (fast != slow) {
                  fast = fast.next;
                  slow = slow.next;
              }
              return fast;
          }
      }
      return null;
  }
}