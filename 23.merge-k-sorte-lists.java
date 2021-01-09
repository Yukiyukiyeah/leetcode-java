/*
 * @Author: your name
 * @Date: 2021-01-09 16:27:54
 * @LastEditTime: 2021-01-09 16:27:55
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/23.merge-k-sorte-lists.java
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
  public ListNode mergeKLists(ListNode[] lists) {
      if (lists.length == 0) return null;
      return merge(lists, 0, lists.length - 1);
  }
  private ListNode merge(ListNode[] lists, int start, int end) {
      if (start == end) return lists[start];
      int mid = start + (end - start) / 2;
      ListNode l1 = merge(lists, start, mid);
      ListNode l2 = merge(lists, mid + 1, end);
      return merge2Lists(l1, l2);
  }
  private ListNode merge2Lists(ListNode l1, ListNode l2) {
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
      ptr.next = l1 != null? l1 : l2;
      return sentinel.next;
  }
}