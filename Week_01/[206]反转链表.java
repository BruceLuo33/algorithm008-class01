//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        /**
         * My solution about the reverse linked list:
         * To reverst the linked list, we need to rever each node in a for-loop.
         * For instance, the input is 1 -> 2 -> 3 -> 4 -> 5 -> NULL,
         * we need to reverse the first node at beginning, which is, 1 <- 2 -> 3 -> 4 -> 5
         * And loop to the end of the list.
         * */
        ListNode prev = null;
        ListNode tmp = null;
        if (head == null) return prev;
        while (head != null) {
            tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
