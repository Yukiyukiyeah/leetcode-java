/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode getKthFromEnd(ListNode head, int k) {
      ListNode slow, fast;
      slow = fast = head;
      while (k > 0) {
          fast = fast.next;
          k --;
      }
      while (fast != null) {
          fast = fast.next;
          slow = slow.next;
      }
      return slow;
  }
}
