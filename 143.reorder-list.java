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
  public void reorderList(ListNode head) {
      if (head == null || head.next == null || head.next.next == null) {
          return;
      }
      ListNode mid = findMidNode(head);
      // while (mid != null) {
      //     System.out.println(mid.val);
      //     mid = mid.next;
      // }
      ListNode rev = reverse(mid);
      // while (rev != null) {
      //     System.out.println(rev.val);
      //     rev = rev.next;
      // }
      merge(head, rev);
  }
  private ListNode findMidNode(ListNode head) {
      ListNode slow, fast;
      slow = head;
      fast = head;
      while (fast.next != null && fast.next.next != null) {
          fast = fast.next.next;
          slow = slow.next;
      }
      ListNode res = slow.next;
      slow.next = null;
      return res;
  }
  private ListNode reverse(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode last = reverse(head.next);
      head.next.next = head;
      head.next = null;
      return last;
  }
  // 1 2
  // 4 3 
  private void merge(ListNode l1, ListNode l2) {
      ListNode head = l1;
      ListNode cur = head;
      l1 = l1.next;
      while (l2 != null) {
          cur.next = l2;
          cur = l2;
          l2 = l2.next;
          if (l1 == null) break;
          cur.next = l1;
          cur = l1;
          l1 = l1.next;
      }
      return;
  }
}
