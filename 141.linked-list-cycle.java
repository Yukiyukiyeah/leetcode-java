/*
 * @Author: your name
 * @Date: 2020-12-13 08:45:04
 * @LastEditTime: 2020-12-13 08:45:16
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/141.linked-list-cycle.java
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
  public boolean hasCycle(ListNode head) {
      ListNode slow, fast;
      slow = fast = head;
      while(fast != null && fast.next != null) {
          fast = fast.next.next;
          slow = slow.next;
          if (fast == slow) {
              return true;
          }
      }
      return false;
  }
}