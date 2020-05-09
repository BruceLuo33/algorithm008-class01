//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 4.20 第一遍，5.7 第二遍
        // 思路：先翻转整个链表，然后从头节点（原来的尾节点）开始计数，删除 nth 节点
        // 然后再翻转一次
        // 复杂度分析：O(2L-1) = O(2N-1)=O(N), 空间复杂度 O（1）

        // 第二个思路：双指针，一遍实现
        // 先让第一个指针走 n 步，这时候开始让第二个指针也开始走
        // 保证两个指针距离为 n
        // 则当第一个指针到达尾节点的时候，第二个指针刚好到达距离尾节点 n 的位置
        // 复杂度分析：O（2L-n）= O(N)，空间复杂度：O（1）

        // 5.7 codes
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode firstMove = sentinel;
        for (int i = 0; i < n; i++) {
            firstMove = firstMove.next;
        }
        ListNode secondMove = sentinel;
        while (firstMove != null && firstMove.next != null) {
            firstMove = firstMove.next;
            secondMove = secondMove.next;
        }
        secondMove.next = secondMove.next.next;
        return sentinel.next;


        // 4.20 codes
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode first = sentinel;
        ListNode second = sentinel;

        // 让第一个指针走 n 步
        // i <= n+1 是因为起点在sentinel，而非第一个节点 n 处
        for (int i = 1; i <= n + 1; i++) {
            if (first != null) first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return sentinel.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
