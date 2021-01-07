/*
 * @Author: your name
 * @Date: 2021-01-06 21:30:02
 * @LastEditTime: 2021-01-06 21:30:03
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Editpublic class 21.merge-two-sorted-lists {
   
 }
 
 * @FilePath: /leetcode-java/21.merge-two-sorted-lists.java
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
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode sentinel = new ListNode();
      ListNode ptr = sentinel;
      while (l1 != null && l2 != null) {
          if (l1.val < l2.val) {
              ptr.next = l1;
              l1 = l1.next;
          } else {
              ptr.next = l2;
              l2 = l2.next;
          }
          ptr = ptr.next;
      }
      ptr.next = l1 == null? l2 : l1;
      return sentinel.next;
  }
}
