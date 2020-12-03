/*
 * @Author: your name
 * @Date: 2020-12-03 13:10:10
 * @LastEditTime: 2020-12-03 13:10:19
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/382.linked-list-random-node-2.java
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
  private ListNode head;
  /** @param head The linked list's head.
      Note that the head is guaranteed to be not null, so it contains at least one node. */
  public Solution(ListNode head) {
      this.head = head;
  }
  
  /** Returns a random node's value. */
  public int getRandom() {
      int scope = 1, chosenValue = 0;
      ListNode curr = this.head;
      while (curr != null) {
          if (Math.random() < 1.0 / scope) {
              chosenValue = curr.val;
          }
          scope += 1;
          curr = curr.next;
      }
      return chosenValue;
  }
}

/**
* Your Solution object will be instantiated and called as such:
* Solution obj = new Solution(head);
* int param_1 = obj.getRandom();
*/
