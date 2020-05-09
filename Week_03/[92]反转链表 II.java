//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
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
    public ListNode reverseBetween(ListNode head, int m, int n) {


        // 4.20 第一遍，5.7 第二遍
        // 思路：分析题目，因为整体分为三个部分：0 - (m - 1) 部分 和 n - end 部分不动，m - n 部分翻转。根据这个结构，我们解题分为三步走。
        // 第一步，遍历到 m - 1 的位置。因为题目给定了 m, n 都是小于链表长度，所以不用考虑超出的情况；
        // 第二步，将 m - n 的整个子链表进行翻转，与206题一致；
        // 第三步，将三个链表连接起来
        // 注意：
        // 复杂度分析：O（N）

        if (m == n) return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode move = sentinel;
        for (int i = 0; i < m - 1; i++) {
            move = move.next;
        }
        ListNode left = move;
        ListNode prev = null;
        ListNode cur = left.next;
        for (int i = 0; i < n - m + 1; i++) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        left.next.next = cur;
        left.next = prev;
        return sentinel.next;


























        if (m == n) return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode listOneEnd = null, listTwoEnd = null;
        int i = 0;
        while (head != null) {
            // i 的初始值要设置为零，并且 i++ 要在三个 if 判断之前
            // 因为若在最后才进行 i++，则因为 continue 的存在，
            // 会使得在 m ~ n 这一部分没有执行 i++。造成环形链表，不停的互相指向。
            i += 1;
            if (i == m ) {
                // listOneEnd 指向 m 之前链表的最后一个node
                // listTwoEnd 指向当前的 m 节点，在翻转之后，这将成为最后一个node
                listOneEnd = prev;
                listTwoEnd = head;
            }
            if (i > m && i < n) {
                // 翻转链表
                // 将后一个 node 的指针指向前一个 node
                ListNode tmp = head.next;
                head.next = prev;
                prev = head;
                head = tmp;
                continue; // 在这个 if 语句中，已经进行了指针的移动，不再需要额外移动指针
            }
            if (i == n) {
                // 链表翻转在此结束，然后进行链表拼接
                // leftOneEnd 指向
                ListNode tmp = head.next;
                head.next = prev;
                listOneEnd.next = head;
                listTwoEnd.next = tmp;
                break;
            }
            // 在三种情况之外，需要手动额外移动 prev 与 head 指针
            head = head.next;
            prev = prev.next;
//            i += 1;
        }
        return sentinel.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
