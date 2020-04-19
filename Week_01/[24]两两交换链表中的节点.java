//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode cur = sentinel;
        while (cur.next != null && cur.next.next != null) {
//            ListNode nodeOne = head;
            ListNode nodeOne = cur.next;
            ListNode nodeTwo = cur.next.next;
            cur.next = nodeTwo;
            nodeOne.next = nodeTwo.next;
            nodeTwo.next = nodeOne;
            cur = nodeOne;
        }
        return sentinel.next;
    }



}
//leetcode submit region end(Prohibit modification and deletion)
