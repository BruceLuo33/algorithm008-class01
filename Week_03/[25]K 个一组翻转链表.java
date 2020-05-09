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


    // 4.17 第一遍，5.6第二遍
    // 思路：整个待翻转的链表分为三个部分：已经翻转的，正要翻转的，还未翻转的。因此我们要做的主要工作就是将其分隔开。
    // 所以我们需要五个指针：一个 sentinel，方便最终返回项；第二个是 subHead，正要翻转的链表的子头节点；
    // 第三个是 toNull，即正要翻转的链表的最后一个节点，在这里将其断开；第四个是 tmp，用来暂时保存还未翻转的链表
    // 最后一个是 tail，用来指向已经翻转后的链表的尾部
    // 注意：将子链表断开后，需要一个 reverseHelper 函数来将其翻转
    // 注意：将子链表翻转后，会得到一个 newSubHead，这时候不能用 `sentinel.next = newSubHead` 来指向它，
    // 因为这会丢失掉前面已经翻转过的子链表，需要用 toNull 来指向它
    // 注意：将 tail 指向翻转后的子链表尾部的时候，要指向 subHead 而不是 head。因为 head 在整个过程中没有动，如果指向 head
    // 就会丢失很多内容。
    // 注意：寻找长度为 k 的子链表的过程中，要用 for 循环而不能用 while。因为 `while(toNull != null)` 的判定条件会使得最终
    // 结束循环的条件为 `toNull == null`，缺少了 `n < k` 这个条件的约束。造成空指针错误
    // 注意：for 循环的时候，结束循环的条件应该是 `count < k - 1`，不是小于 k 的原因在于，toNull 指针设置的是指向 head，
    // 相当于 k 的长度小了 1.
    // 复杂度分析：O（N）
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode toNull = head;
        ListNode subHead = head;
        ListNode tail = sentinel;

        while (subHead != null) {
            for (int count = 0; count < k - 1; count++) {
                toNull = toNull.next;
                if (toNull == null) return sentinel.next;
            }

            ListNode tmp = toNull.next;
            toNull.next = null;
            ListNode newSubHead = reverse(subHead);
            tail.next = newSubHead;
            tail = subHead;
            subHead = tmp;
            toNull = tmp;
            tail.next = tmp;

        }
        return sentinel.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = null;
        while (head != null ) {
            cur = head.next;
            head.next = prev;
            prev = head;
            head = cur;
        }
        return prev;
    }






























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
        while (head != null ) {
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









