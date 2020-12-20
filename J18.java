/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode deleteNode(ListNode head, int val) {
      ListNode prefix = new ListNode();
      prefix.next = head;
      ListNode res = prefix;
      while (prefix.next.val != val) {
          prefix = prefix.next;
      }
      prefix.next = prefix.next.next;
      return res.next;
  }
}
