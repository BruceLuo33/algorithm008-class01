//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode move = sentinel;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        /**
         * 引入sentinel node，方便return
         * 不能再引入 moveOne/moveTwo 指向 l1/l2 的原因：
         * 会将sentinel指向空指针，并且并没有形成新的链表。*/

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                move.next = l1;
                l1 = l1.next;
            } else {
                move.next = l2;
                l2 = l2.next;
            }
            move = move.next;
        }
        /**
         * 上述循环只用完了短链表中的值，但是对于长链表，还有node没有连接上
         * 因为while循环是从小到大排列，所以接下来剩余的链表，直接连到move最后就可以了*/
        move.next = l1 == null ? l2 : l1;
        return sentinel.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
