/*
 * @Author: your name
 * @Date: 2020-12-30 12:49:34
 * @LastEditTime: 2021-01-03 12:36:26
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode-java/2.add-two-numbers.java
 */
import java.util.*;

public class 2.add-two-numbers {
  public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
    ListNode res = new ListNode();
        ListNode ptr = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int val = val1 + val2 + carry;
            if (val > 9) {
                val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ptr.next = new ListNode(val);
            ptr = ptr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return res.next;
  }
}
