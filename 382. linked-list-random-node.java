/*
 * @Author: your name
 * @Date: 2020-12-03 13:05:12
 * @LastEditTime: 2020-12-03 13:05:13
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/382. linked-list-random-node.java
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
  ListNode head;
  /** @param head The linked list's head.
      Note that the head is guaranteed to be not null, so it contains at least one node. */
  public Solution(ListNode head) {
      this.head  = head;
  }
  
  /** Returns a random node's value. */
  public int getRandom() {
      ListNode ptr = head;
      Random rand = new Random();
      int count = 0;
      while (ptr != null) {
          ptr = ptr.next;
          count++;
      }
      int rand_int = rand.nextInt(count);
      System.out.println(rand_int);
      count = 0;
      ptr = head;
      while (count < rand_int) {
          ptr = ptr.next;
          count++;
      }
      return ptr.val;
  }
}

/**
* Your Solution object will be instantiated and called as such:
* Solution obj = new Solution(head);
* int param_1 = obj.getRandom();
*/