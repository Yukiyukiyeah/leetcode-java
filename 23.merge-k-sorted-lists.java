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
      ListNode sentinel = new ListNode();
      int k = lists.length;
      ListNode ptr = sentinel;
      while (true) {
          ListNode minNode = null;
          int minPtr = -1;
          for (int i = 0; i < k; i++) {
              if (lists[i] == null) continue;
              if (minNode == null || lists[i].val < minNode.val) {
                  minNode = lists[i];
                  minPtr = i;
              }
          }
          if (minNode == null) break;
          ptr.next = minNode;
          ptr = ptr.next;
          lists[minPtr] = lists[minPtr].next;
      }
      return sentinel.next;
  }
}
