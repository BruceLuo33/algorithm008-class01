//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        //五个Listnode initialization
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode tail = sentinel;
        ListNode subHead = head;
        ListNode isNull = head;

        // while 的判定不用 head != null 的原因在于：
        // 第一次翻转链表之后，head将会变成翻转链表的tail，
        // 并且指向设立的空节点null，所以while将会一直为真（存疑，因为while并没有死循环）
        while (subHead != null) {
            // for 循环的次数是 k-2，相当于判断加上 head
            // 及其之后的 k-1 个 node 是否为null
            for (int i = 0; i < k - 1 ; i++) {
                isNull = isNull.next;
                if (isNull == null) return sentinel.next;
            }

            // 保存 k+1 个 node 之后的链表地址
            ListNode tmp = isNull.next;
            // 将 head 到之后 k 个节点的链表断开
            isNull.next = null;
            ListNode tmpSubHead = reverse(subHead);
            // 此时的tail 还是指向 sentinel
            // tmpSubHead 是翻转之后的链表，将其拼接到tail后面
            // 也就是sentinel后面
            tail.next = tmpSubHead;
            // reverse 之后，subHead成了尾节点，将tail指向subHead，相当于之前
            // 将 tail 指向sentinel，此步骤为了更新 tail 节点
            // 注意因为翻转操作，此时的subHead已经从之前的头部变成了尾部
            tail = subHead;
            // isNull 指向之前保存的 k+1 节点
            isNull = tmp;
            // 更新 subHead，将其重新指向下一段未翻转的链表处
            subHead = tmp;
            tail.next = tmp;
        }
        return sentinel.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = null;
        while (head != null) {
            cur = head.next;
            head.next = prev;
            prev = head;
            head = cur;
        }
        return prev;

//        ListNode prev = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode tmp = cur.next;
//            head.next = prev;
//            prev = cur;
//            cur = tmp;
//        }
//        return prev;

    }
}
//leetcode submit region end(Prohibit modification and deletion)









