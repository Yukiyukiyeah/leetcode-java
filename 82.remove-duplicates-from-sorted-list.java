/*
 * @Author: your name
 * @Date: 2020-12-05 18:12:53
 * @LastEditTime: 2020-12-05 18:12:54
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/82.remove-duplicates-in-sorted-linked-list.java
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
  public ListNode deleteDuplicates(ListNode head) {
      ListNode dummy = new ListNode();
      dummy.next = head;
      ListNode slow = dummy;
      while (slow.next != null && slow.next.next != null) {
          if(slow.next.val == slow.next.next.val) {
              ListNode fast = slow.next.next;
              while (fast != null && fast.val == slow.next.val) {
                  fast  = fast.next;
              }
              slow.next = fast;
          } else{
              slow = slow.next;
          }
      }
      return dummy.next;
  }
}